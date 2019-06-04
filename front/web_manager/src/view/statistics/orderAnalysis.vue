<template>
  <div class="chart">
    <el-collapse v-model="activeNames" @change="handleChange" accordion>
      <el-collapse-item name="1">
        <template slot="title">
          <div class="chart-title">
            昨日订单指标
          </div>
        </template>
        <div class="chart-box">
          <div class="total-data">
            <p class="data-1">新增订单数</p>
            <p class="data-2" v-if="ydayAnalyAndDetails">{{ydayAnalyAndDetails.totalOrderNum}}</p>
            <p class="data-2" v-else>0</p>
          </div>

          <div class="total-data total-center">
            <p class="data-1">成功支付订单</p>
            <p class="data-2" v-if="ydayAnalyAndDetails">{{ydayAnalyAndDetails.succPayOrderNum}}</p>
            <p class="data-2" v-else>0</p>
          </div>

          <div class="total-data">
            <p class="data-1">成功支付金额</p>
            <p class="data-2" v-if="ydayAnalyAndDetails">{{ydayAnalyAndDetails.succPayOrderMoney}}</p>
            <p class="data-2" v-else>0</p>
          </div>

        </div>
      </el-collapse-item>

      <div class="filling"></div>

      <el-collapse-item name="2">
        <template slot="title">
          <div class="chart-title">
            7日订单指标
          </div>
        </template>
        <div>
          <div class="chart-target">
            <div class="chart-target-1">
              <h3 class="chart-target-title">各项指标</h3>
              <p>订单总数：{{sevenDaysAnalyAndDetails.totalOrderNum}}</p>
              <p>已付款：{{sevenDaysAnalyAndDetails.succPayOrderNum}}</p>
              <p>未付款：{{sevenDaysAnalyAndDetails.unPayOrderNum}}</p>
              <p>支付成功金额：{{sevenDaysAnalyAndDetails.succPayOrderMoney}}</p>
            </div>
            <div class="chart-target-2">
              <div id="main" style="width: 400px;height:300px;" class="main"></div>
            </div>
          </div>
        </div>
      </el-collapse-item>

      <div class="filling"> </div>

      <el-collapse-item name="3">
        <template slot="title">
          <div class="chart-title">
            15日订单指标
          </div>
        </template>
        <div>
          <div class="chart-target">
            <div class="chart-target-1">
              <h3 class="chart-target-title">各项指标</h3>
              <p>订单总数：{{halfMonthAnalyAndDetails.totalOrderNum}}</p>
              <p>已付款：{{halfMonthAnalyAndDetails.succPayOrderNum}}</p>
              <p>未付款：{{halfMonthAnalyAndDetails.unPayOrderNum}}</p>
              <p>支付成功金额：{{halfMonthAnalyAndDetails.succPayOrderMoney}}</p>
            </div>
            <div class="chart-target-2">
              <div id="main2" style="width: 400px;height:300px;" class="main"></div>
            </div>
          </div>
        </div>
      </el-collapse-item>

      <div class="filling"></div>

      <el-collapse-item name="4">
        <template slot="title">
          <div class="chart-title">
            30日订单指标
          </div>
        </template>
        <div>
          <div class="chart-target">
            <div class="chart-target-1">
              <h3 class="chart-target-title">各项指标</h3>
              <p>订单总数：{{monthAnalyAndDetails.totalOrderNum}}</p>
              <p>已付款：{{monthAnalyAndDetails.succPayOrderNum}}</p>
              <p>未付款：{{monthAnalyAndDetails.unPayOrderNum}}</p>
              <p>支付成功金额：{{monthAnalyAndDetails.succPayOrderMoney}}</p>
            </div>
            <div class="chart-target-2">
              <div id="main3" style="width: 400px;height:300px;" class="main"></div>
            </div>
          </div>
        </div>
      </el-collapse-item>

      <div class="filling"></div>
      <el-collapse-item name="5">
        <template slot="title">
          <div class="chart-title">
            <el-dropdown @command="Command">
              <span class="el-dropdown-link">
                {{value1}}至{{value2}}<i class="el-icon-caret-bottom el-icon--right"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="a">7日订单指标</el-dropdown-item>
                <el-dropdown-item command="b">15日订单指标</el-dropdown-item>
                <el-dropdown-item command="c">30日订单指标</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </template>
        <div class="chart-target">
          <div class="chart-target-2">
            <!--列表-->
            <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;">
              <el-table-column prop="analysisDate" label="时间" min-width="100" align="center">
              </el-table-column>
              <el-table-column prop="orderNum" label="订单总数" min-width="80" show-overflow-tooltip align="center">
              </el-table-column>
              <el-table-column prop="payNum" label="已支付数" min-width="60" align="center">
              </el-table-column>
              <el-table-column prop="unPayNum" label="未支付数" min-width="60" align="center">
              </el-table-column>
              <el-table-column prop="payMoney" label="当日支付成功金额" min-width="60" align="center">
              </el-table-column>
            </el-table>
            <!-- 分页 -->
            <div class="paging">
              <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="4" layout="total, prev, pager, next, jumper" :total="total">
              </el-pagination>
            </div>
          </div>
        </div>
        <div>

        </div>
      </el-collapse-item>

    </el-collapse>

  </div>

</template>

<script>
import { Dates } from "@/apis/mUtils";
import { orderAnalysisList } from "@/apis/api";
let echarts = require("echarts/lib/echarts");
// 引入柱状图组件
require("echarts/lib/chart/pie");
// 引入提示框和title组件
require("echarts/lib/component/tooltip");
require("echarts/lib/component/title");
require("echarts/lib/component/legend");
export default {
  data() {
    return {
      activeNames: ["1"],
      value1: "",
      value2: "",
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 10, //总条数
      //搜索
      //具体列表
      orders: {},
      ydayAnalyAndDetails: {},
      sevenDaysAnalyAndDetails: {},
      halfMonthAnalyAndDetails: {},
      monthAnalyAndDetails: {},
      userlist: [],
      users: [],
      ids: -1,
      listLoading: false //刷新
    };
  },

  mounted() {
    this.getUsers();
    // setTimeout(res => {
    //   this.drawLine();
    //   this.drawLine2();
    //   this.drawLine3();
    // }, 1500);
    this.newDate(7);
  },
  methods: {
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.users = this.userlist.slice(
        (this.currentPage - 1) * 4,
        this.currentPage * 4
      );
      // this.getUsers();
      console.log(`当前页: ${val}`);
    },

    // 获取用户列表：
    getUsers() {
      orderAnalysisList().then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
        this.ydayAnalyAndDetails = data.ydayAnalyAndDetails;
        this.sevenDaysAnalyAndDetails = data.sevenDaysAnalyAndDetails;
        this.halfMonthAnalyAndDetails = data.halfMonthAnalyAndDetails;
        this.monthAnalyAndDetails = data.monthAnalyAndDetails;
        this.userlist = this.sevenDaysAnalyAndDetails.analysisList;
        console.log(data);
      });
    },

    Command(a) {
      if (a == "a") {
        this.newDate(7);
        this.userlist = this.sevenDaysAnalyAndDetails.analysisList;
        this.total = this.userlist.length;
      } else if (a == "b") {
        this.newDate(15);
        this.userlist = this.halfMonthAnalyAndDetails.analysisList;
        this.total = this.userlist.length;
      } else {
        this.newDate(30);
        this.userlist = this.monthAnalyAndDetails.analysisList;
        this.total = this.userlist.length;
      }
      this.currentPage = 1;
      this.users = this.userlist.slice(0, 4);
      console.log(this.userlist);
    },
    newDate(a) {
      this.value2 = Dates.formatDate(Date.now() - 8.64e7, "yyyy年MM月dd");
      this.value1 = Dates.formatDate(Date.now() - 8.64e7 * a, "yyyy年MM月dd");
    },

    //饼图
    handleChange(a) {
      if (a == 2) {
        this.drawLine();
      } else if (a == 3) {
        this.drawLine2();
      } else if (a == 4) {
        this.drawLine3();
      } else if (a == 5) {
        this.newDate(7);
        this.userlist = this.sevenDaysAnalyAndDetails.analysisList;
        this.total = this.userlist.length;
        this.users = this.userlist.slice(
          (this.currentPage - 1) * 4,
          this.currentPage * 4
        );
      }
    },
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById("main"));
      // 绘制图表
      myChart.setOption({
        title: {
          text: "7日订单指标",
          left: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          left: 10,
          top: 20,
          data: ["待付款", "已付款"]
        },
        series: [
          {
            name: "订单",
            type: "pie",
            radius: "60%",
            center: ["50%", "50%"],
            selectedMode: "single",
            data: [
              {
                value: this.sevenDaysAnalyAndDetails.unPayOrderNum,
                name: "待付款"
              },
              {
                value: this.sevenDaysAnalyAndDetails.succPayOrderNum,
                name: "已付款"
              }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
          }
        ]
      });
    },
    drawLine2() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById("main2"));
      // 绘制图表
      myChart.setOption({
        title: {
          text: "15日订单指标",
          left: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          left: 10,
          top: 20,
          data: ["待付款", "已付款"]
        },
        series: [
          {
            name: "订单",
            type: "pie",
            radius: "60%",
            center: ["50%", "50%"],
            selectedMode: "single",
            data: [
              {
                value: this.halfMonthAnalyAndDetails.unPayOrderNum,
                name: "待付款"
              },
              {
                value: this.halfMonthAnalyAndDetails.succPayOrderNum,
                name: "已付款"
              }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
          }
        ]
      });
    },
    drawLine3() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById("main3"));
      // 绘制图表
      myChart.setOption({
        title: {
          text: "30日订单指标",
          left: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          left: 10,
          top: 20,
          data: ["待付款", "已付款"]
        },
        series: [
          {
            name: "订单",
            type: "pie",
            radius: "60%",
            center: ["50%", "50%"],
            selectedMode: "single",
            data: [
              {
                value: this.monthAnalyAndDetails.unPayOrderNum,
                name: "待付款"
              },
              {
                value: this.monthAnalyAndDetails.succPayOrderNum,
                name: "已付款"
              }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
          }
        ]
      });
    }
  }
};
</script>


<style lang="less" scoped>
.chart-title {
  background-color: #eee;
  font-size: 18px;
  padding-left: 10px;
  padding-right: 10px;
  .el-dropdown {
    font-size: 18px;
    color: #303133;
  }
}

.filling {
  height: 15px;
  background: #fff;
}
.chart-box {
  display: flex;
  .total-data {
    flex: 1;
    height: 200px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    margin: 50px 0;
    .data-1 {
      font-size: 16px;
    }
    .data-2 {
      font-size: 32px;
    }
  }
  .total-center {
    border-left: #eee 1px solid;
    border-right: #eee 1px solid;
  }
}

.chart-target {
  display: flex;
  .chart-target-1 {
    margin: 40px 0;
    padding-left: 30px;
    flex: 2;
    .chart-target-title {
      font-size: 21px;
      height: 60px;
      line-height: 60px;
    }
    p {
      font-size: 16px;
    }
    p:nth-child(4) {
      height: 60px;
    }
  }
  .chart-target-2 {
    padding-left: 30px;
    flex: 3;
    div {
      margin: 40px 0;
    }
    .paging {
      margin: 10px auto;
      text-align: center;
    }
  }
  .el-dropdown-link {
    background-color: #eee;
    font-size: 18px;
  }
}
</style>


