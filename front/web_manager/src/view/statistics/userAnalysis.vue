<template>
  <div class="chart">
    <el-collapse v-model="activeNames" @change="handleChange" accordion>
      <el-collapse-item name="1">
        <template slot="title">
          <div class="chart-title">
            今日核心指标
          </div>
        </template>
        <div class="chart-box">

          <div class="total-data">
            <p class="data-1">新注册用户</p>
            <p class="data-2">{{ydayAnalysisCollect.newRegistNum}}</p>

          </div>

          <div class="total-data total-center">
            <p class="data-1">今日访问</p>
            <p class="data-2">{{ydayAnalysisCollect.visitNum}}</p>
          </div>

          <div class="total-data">
            <p class="data-1">累计注册</p>
            <p class="data-2">{{ydayAnalysisCollect.totalRegistNum}}</p>
          </div>

        </div>
      </el-collapse-item>

      <div class="filling"></div>

      <el-collapse-item name="2">
        <template slot="title">
          <div class="chart-title">
            7日核心指标
          </div>
        </template>
        <div>
          <div class="chart-target">

            <div class="chart-target-2">
              <div id="main" style="width: 1000px;height:500px;" class="main"></div>
            </div>
          </div>
        </div>
      </el-collapse-item>

      <div class="filling"> </div>

      <el-collapse-item name="3">
        <template slot="title">
          <div class="chart-title">
            15日核心指标
          </div>
        </template>
        <div>
          <div class="chart-target">

            <div class="chart-target-2">
              <div id="main2" style="width: 1000px;height:500px;" class="main"></div>
            </div>
          </div>
        </div>
      </el-collapse-item>

      <div class="filling"></div>

      <el-collapse-item name="4">
        <template slot="title">
          <div class="chart-title">
            30日核心指标
          </div>
        </template>
        <div>
          <div class="chart-target">
            <div class="chart-target-2">
              <div id="main3" style="width: 1000px;height:500px;" class="main"></div>
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
        <div class="chart-target-3">
          <div class="chart-target-4">
            <!--列表-->
            <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;">
              <el-table-column label="序号" type="index" width="50" align="center">
              </el-table-column>
              <el-table-column prop="countDate" label="注册时间" min-width="100" show-overflow-tooltip align="center">
              </el-table-column>
              <el-table-column prop="newRegistNum" label="新注册数" min-width="80" align="center">
              </el-table-column>
              <el-table-column prop="visitNum" label="日访问" min-width="80" align="center">
              </el-table-column>
              <el-table-column prop="totalRegistNum" label="累计注册" min-width="80" align="center">
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

import { registAnalysisList } from "@/apis/api";
let echarts = require("echarts/lib/echarts");
// 引入折线图组件
require("echarts/lib/chart/line");

// 引入提示框和title组件
require("echarts/lib/component/tooltip");
require("echarts/lib/component/title");
require("echarts/lib/component/legend");

export default {
  data() {
    return {
      activeNames: ["1"],
      value3: "",
      value1: "",
      value2: "",
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      //具体列表
      orders: {},
      ydayAnalysisCollect: {},
      sevenDaysAnalyAndDetails: {},
      sevenlist: {},
      halfMonthAnalysisCollect: {},
      halfMonthlist: {},
      monthAnalysisCollect: {},
      monthlist: {},
      userlist: [],
      users: [],
      listLoading: false, //刷新,
      a: ""
    };
  },
  mounted() {
    this.getUsers();
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
      console.log(`当前页: ${val}`);
    },

    // 获取用户列表：
    getUsers() {
      registAnalysisList().then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
        this.ydayAnalysisCollect = data.ydayAnalysisCollect[0];
        this.sevenDayAnalysisCollect = data.sevenDayAnalysisCollect;
        this.halfMonthAnalysisCollect = data.halfMonthAnalysisCollect;
        this.monthAnalysisCollect = data.monthAnalysisCollect;
        this.userlist = this.sevenDayAnalysisCollect.analysisList;
        console.log(data);
      });
      this.users = [{ id: 1 }];
    },
    Command(a) {
      this.a = a;
      if (a == "a") {
        this.newDate(7);
        this.userlist = this.sevenDayAnalysisCollect;
        this.total = this.userlist.length;
      } else if (a == "b") {
        this.newDate(15);
        this.userlist = this.halfMonthAnalysisCollect;
        this.total = this.userlist.length;
      } else {
        this.newDate(30);
        this.userlist = this.monthAnalysisCollect;
        this.total = this.userlist.length;
      }
      this.currentPage = 1;
      this.users = this.userlist.slice(0, 4);
      console.log(this.userlist);
    },
    newDate(a) {
      // let end = new Date() - 8.64e7;
      // let start = new Date();
      // start.setTime(start.getTime() - 3600 * 1000 * a * 30);
      this.value2 = Dates.formatDate(Date.now(), "yyyy年MM月dd");
      this.value1 = Dates.formatDate(Date.now() - 8.64e7 *(a-1), "yyyy年MM月dd");
    },

    handleChange(a) {
      if (a == 2) {
        let para = {
          countDate: [],
          newRegistNum: [],
          visitNum: [],
          totalRegistNum: []
        };
        this.sevenDayAnalysisCollect.forEach(item => {
          para.countDate.unshift(item.countDate);
          para.newRegistNum.unshift(item.newRegistNum);
          para.visitNum.unshift(item.visitNum);
          para.totalRegistNum.unshift(item.totalRegistNum);
        });
        this.sevenlist = para;
        console.log(this.sevenlist);
        this.drawLine();
      } else if (a == 3) {
        let para = {
          countDate: [],
          newRegistNum: [],
          visitNum: [],
          totalRegistNum: []
        };
        this.halfMonthAnalysisCollect.forEach(item => {
          para.countDate.unshift(item.countDate);
          para.newRegistNum.unshift(item.newRegistNum);
          para.visitNum.unshift(item.visitNum);
          para.totalRegistNum.unshift(item.totalRegistNum);
        });
        this.halfMonthlist = para;
        console.log(this.halfMonthlist);
        this.drawLine2();
      } else if (a == 4) {
        let para = {
          countDate: [],
          newRegistNum: [],
          visitNum: [],
          totalRegistNum: []
        };
        this.monthAnalysisCollect.forEach(item => {
          para.countDate.unshift(item.countDate);
          para.newRegistNum.unshift(item.newRegistNum);
          para.visitNum.unshift(item.visitNum);
          para.totalRegistNum.unshift(item.totalRegistNum);
        });
        this.monthlist = para;
        console.log(this.monthlist);
        this.drawLine3();
      } else if (a == 5) {
        this.newDate(7);
        this.userlist = this.sevenDayAnalysisCollect;
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
          text: "折线图"
        },
        xAxis: {
          type: "category",
          data: this.sevenlist.countDate
        },
        legend: {
          data: ["注册量", "日访问", "累计注册"]
        },
        tooltip: {
          trigger: "axis"
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            name: "注册量",
            type: "line",
            stack: "总量1",
            data: this.sevenlist.newRegistNum,
            itemStyle: {
              normal: {
                color: "#FF0000",
                lineStyle: {
                  color: "#FF0000"
                }
              }
            }
          },
          {
            name: "日访问",
            type: "line",
            stack: "总量2",
            data: this.sevenlist.visitNum,
            itemStyle: {
              normal: {
                color: "#EEEE00",
                lineStyle: {
                  color: "#EEEE00"
                }
              }
            }
          },
          {
            name: "累计注册",
            type: "line",
            stack: "总量3",
            data: this.sevenlist.totalRegistNum,
            itemStyle: {
              normal: {
                color: "#63B8FF",
                lineStyle: {
                  color: "#63B8FF"
                }
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
          text: "折线图"
        },
        xAxis: {
          type: "category",
          data: this.halfMonthlist.countDate
        },
        legend: {
          data: ["注册量", "日访问", "累计注册"]
        },
        tooltip: {
          trigger: "axis"
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            name: "注册量",
            type: "line",
            stack: "总量1",
            data: this.halfMonthlist.newRegistNum,
            itemStyle: {
              normal: {
                color: "#FF0000",
                lineStyle: {
                  color: "#FF0000"
                }
              }
            }
          },
          {
            name: "日访问",
            type: "line",
            stack: "总量2",
            data: this.halfMonthlist.visitNum,
            itemStyle: {
              normal: {
                color: "#EEEE00",
                lineStyle: {
                  color: "#EEEE00"
                }
              }
            }
          },
          {
            name: "累计注册",
            type: "line",
            stack: "总量3",
            data: this.halfMonthlist.totalRegistNum,
            itemStyle: {
              normal: {
                color: "#63B8FF",
                lineStyle: {
                  color: "#63B8FF"
                }
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
          text: "折线图"
        },
        xAxis: {
          type: "category",
          data: this.monthlist.countDate
        },
        legend: {
          data: ["注册量", "日访问", "累计注册"]
        },
        tooltip: {
          trigger: "axis"
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            name: "注册量",
            type: "line",
            stack: "总量1",
            data: this.monthlist.newRegistNum,
            itemStyle: {
              normal: {
                color: "#FF0000",
                lineStyle: {
                  color: "#FF0000"
                }
              }
            }
          },
          {
            name: "日访问",
            type: "line",
            stack: "总量2",
            data: this.monthlist.visitNum,
            itemStyle: {
              normal: {
                color: "#EEEE00",
                lineStyle: {
                  color: "#EEEE00"
                }
              }
            }
          },
          {
            name: "累计注册",
            type: "line",
            stack: "总量3",
            data: this.monthlist.totalRegistNum,
            itemStyle: {
              normal: {
                color: "#63B8FF",
                lineStyle: {
                  color: "#63B8FF"
                }
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
  justify-content: center;
  align-items: center;
  .chart-target-2 {
    div {
      margin: 40px 0;
    }
    .paging {
      margin: 10px auto;
      text-align: right;
    }
  }
}

.chart-target-3 {
  display: flex;
  .chart-target-4 {
    padding-left: 30px;
    flex: 3;
    div {
      margin: 50px 0;
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

