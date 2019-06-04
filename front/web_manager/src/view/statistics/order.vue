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
        <el-form-item>
          <el-button type="primary" @click="getUse">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">
      <el-table-column label="序号" type="index" width="50" align="center">
      </el-table-column>
      <el-table-column prop="payDate" label="支付时间" width="150" show-overflow-tooltip align="center">
      </el-table-column>
      <el-table-column prop="payTotalAmount" label="支付金额" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="tradeIOSNum" label="金额（IOS）" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="tradeAndroidNum" label="金额（Android）" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="tradeTotalNum" label="交易笔数" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="iosAmount" label="IOS笔数" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="androidAmount" label="Android笔数）" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="iosStoreTradeNum" label="ios-store" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="aliPayTradeNum" label="Alipay" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="wxPayTradeNum" label="Wechat" min-width="80" align="center">
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
import { orderCountList } from "@/apis/api";
import { Utils, Dates } from "@/apis/mUtils";
export default {
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        value1: "",
        value2: ""
      },
      //具体列表
      users: [],
      listLoading: false, //刷新
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() > Date.now() - 8.64e7;
        }
      },
      pickerOptions1: {
        disabledDate: time => {
          return time.getTime() > Date.now() - 8.64e7;
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
    getUse() {
      this.currentPage = 1;
      this.getUsers();
    },
    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        startDate: this.filters.value1,
        endDate: this.filters.value2,
        pageSize: 10,
        pageNo: this.currentPage
      };
      console.log(para);
      orderCountList(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取数据失败`);
            return false;
          }
          let data = res.data.data;
          this.users = data.data;
          this.total = data.count;
          this.listLoading = false;
        })
        .catch(() => {
          this.listLoading = false;
        });
    }
  },
  computed: {},
  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.getCurrentMonthFirst();
    this.filters.value2 = Dates.getFormatDate(Date.now());
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