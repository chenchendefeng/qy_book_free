<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <span class="demonstration">时间：</span>
          <el-date-picker v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy-MM-dd" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <span>渠道：</span>
          <el-select v-model="filters.rids" placeholder="全部" style="width: 90px;">
            <el-option :label="item.name" :value="item.channle" v-for="item of role" :key=item.id>
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getUse">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" @selection-change="selsChange" style="width: 100%;" header-align="center" :header-cell-style="{background:'#eee'}" border>
      <el-table-column prop="systemType" label="客户端类型" min-width="80" align="center">
      </el-table-column>
      <el-table-column label="渠道" min-width="80" align="center">
        <template slot-scope="scope">
          {{scope.row.channelName}}({{scope.row.channel}})
        </template>
      </el-table-column>
      <el-table-column prop="registerNum" label="数量" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="payMoney" label="充值" min-width="80" align="center">
      </el-table-column>

      <!-- <el-table-column label="操作" align="right">
                <template slot-scope="scope">
                    <el-button
                    size="small"
                     @click="handleEdit(scope.$index, scope.row)"
                    >修改</el-button>
                    <el-button
                    size="small"
                    type="warning"
                    @click="handleSettings(scope.$index, scope.row)"
                    >修改密码</el-button>
                    <el-button
                    size="small"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)"
                    >删除</el-button>
                </template>
      </el-table-column> -->
    </el-table>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
  </section>
</template>

<script>
import { registResourceList } from "@/apis/api";
import { Utils, Dates, getStore } from "@/apis/mUtils";
export default {
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        value1: "",
        value2: "",
        rids: ""
      },
      //具体列表
      users: [],
      ids: -1,
      listLoading: false, //刷新
      sels: [], //列表选中列
      value1: "",
      value2: "",
      role: JSON.parse(getStore("role") || "[]"),
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      },
      pickerOptions1: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      }
    };
  },
  methods: {
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getUsers();
      console.log(`当前页: ${val}`);
    },
    selsChange(val) {
      var arr = [];
      val.forEach(function(item) {
        arr.push(item.id);
      });
      this.sels = arr;
    },
    getUse() {
      this.currentPage = 1;
      this.getUsers();
    },
    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        pageSize: 10,
        pageNo: this.currentPage,
        startDate: this.filters.value1,
        endDate: this.filters.value1,
        channel: this.filters.rids
      };
      registResourceList(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取数据失败`);
            return false;
          }
          let data = res.data.data.data;
          console.log(data);
          this.users = data.data;
          this.total = data.count;
          this.listLoading = false;
        })
        .catch(() => {
          this.listLoading = false;
        });
    }
  },

  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.formatDate(Date.now(), "yyyy-MM-dd");
    this.filters.value2 = Dates.formatDate(Date.now(), "yyyy-MM-dd");
    this.getUsers();
  }
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;
  text-align: center;
}
.toolbar {
  margin-bottom: 50px;
}
</style>