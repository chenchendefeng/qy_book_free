<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <span class="demonstration">日期：</span>
          <el-date-picker v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy-MM-dd" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getUse">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">
      <el-table-column prop="userName" label="用户信息" min-width="80" align="center">
        <template slot-scope="scope">
          <el-button size="small" type="text" @click="handleEdit(scope.$index, scope.row)">{{scope.row.name}}</el-button>
        </template>
      </el-table-column>
      <el-table-column prop="regDate" label="注册时间" min-width="80" show-overflow-tooltip align="center">
      </el-table-column>
      <el-table-column prop="source" label="客户端类型" min-width="80" align="center">
      </el-table-column>
      <el-table-column label="注册渠道" min-width="80" align="center">
        <template slot-scope="scope">
          {{scope.row.registChannelName}}({{scope.row.registChannel}})
        </template>
      </el-table-column>
      <el-table-column prop="imei" label="设备码" min-width="80" align="center" :show-overflow-tooltip="true">
      </el-table-column>

    </el-table>

    <!--用户详情-->
    <el-dialog title="用户详情" :visible.sync="FormVisible" width="1000px" @closed="close">
      <particular :uid="uid" @hiden="show" ref="userin"></particular>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import { userFirstRegistList } from "@/apis/api";
import { Utils, Dates } from "@/apis/mUtils";
import particular from "@/components/common/particular";
export default {
  components: {
    particular
  },
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        value1: ""
      },
      //具体列表
      users: [],
      uid: "",
      listLoading: false, //刷新
      FormVisible: false,
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
    //子隐藏
    show() {
      this.FormVisible = false;
    },
    //关闭弹窗时候触发
    close() {
      this.$refs.userin.Userlist();
      this.getUsers();
    },
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getUsers();
      console.log(`当前页: ${val}`);
    },

    getUse() {
      this.currentPage = 1;
      this.getUsers();
    },
    // 获取列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        pageSize: 10,
        pageNo: this.currentPage,
        date: this.filters.value1
      };
      console.log(para);
      userFirstRegistList(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取数据失败`);
            return false;
          }
          let data = res.data.data;
          this.users = data.data;
          this.total = data.count;
          this.listLoading = false;
          console.log(data);
        })
        .catch(() => {
          this.listLoading = false;
        });
    },
    handleEdit(index, row) {
      this.uid = row.uid;
      this.FormVisible = true;
    }
  },

  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.formatDate(Date.now(), "yyyy-MM-dd");
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
  margin-bottom: 30px;
}
</style>