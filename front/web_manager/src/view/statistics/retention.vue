<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <span class="demonstration">开始时间：</span>
          <el-date-picker v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy-MM-dd" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <span class="demonstration">结束时间：</span>
          <el-date-picker v-model="filters.value2" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy-MM-dd" :picker-options="pickerOptions1">
          </el-date-picker>
        </el-form-item>
        <!-- <el-form-item>
          <span>客户端：</span>
          <el-select
            v-model="filters.rids1"
            placeholder="全部"
            style="width: 90px;"
          >
            <el-option
              label="安卓"
              value="0"
            >
            </el-option>
            <el-option
              label="IOS"
              value="1"
            >
            </el-option>
            <el-option
              label="全部"
              value="2"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item>
          <span>渠道：</span>
          <el-select
            v-model="filters.rids2"
            placeholder="全部"
            style="width: 90px;"
          >
            <el-option
              :label="item.roleName"
              :value="item.id"
              v-for="item of role"
              :key=item.id
            >
            </el-option>
          </el-select>
        </el-form-item> -->

        <el-form-item>
          <el-button type="primary" @click="getUse">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" header-align="center" :header-cell-style="{background:'#eee'}" border>

      <el-table-column prop="countDateStr" label="时间" min-width="100" show-overflow-tooltip align="center">
      </el-table-column>
      <el-table-column prop="registNum" label="注册" min-width="100" align="center">
      </el-table-column>
      <el-table-column prop="oneDayAlive" label="1日留存" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="threeDaysAlive" label="3日留存" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="sevenDaysAlive" label="7日留存" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="halfMonthAlive" label="15日留存" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="oneMonthAlive" label="30日留存" min-width="60" align="center">
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>
  </section>
</template>

<script>
import { userAliveAnalysisList } from "@/apis/api";
import { Utils, Dates ,getStore} from "@/apis/mUtils";
export default {
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        rids1: "",
        rids2: "",
        value1: "",
        value2: ""
      },

      //具体列表
      users: [],
      listLoading: false, //刷新
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
    getUse() {
      this.currentPage = 1;
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

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        pageSize: 10,
        pageNo: this.currentPage,
        startDate: this.filters.value1,
        endDate: this.filters.value2
      };
      userAliveAnalysisList(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取数据失败`);
            return false;
          }
          let data = res.data.data.data;
          this.users = data.data;
          this.total = data.count;
          console.log(data);
          this.listLoading = false;
        })
        .catch(() => {
          this.listLoading = false;
        });
    }
  },

  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.formatDate(
      Date.now() - 8.64e7 * 30,
      "yyyy-MM-dd"
    );
    this.filters.value2 = Dates.formatDate(Date.now() - 8.64e7, "yyyy-MM-dd");
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