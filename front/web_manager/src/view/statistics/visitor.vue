<template>
  <div class="visi">
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item label="选择日期：">
          <el-date-picker style="width: 180px;" v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getUs">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <div class="fangke">
      <div class="fangke-item">
        <p>当天访客总人数：{{fangke.visitCount}}</p>
      </div>
      <div class="fangke-item">
        <p>当天访客新注册：{{fangke.registCount}}</p>
      </div>
      <div class="fangke-item">
        <p>当天访客转化率：{{fangke.conversionRate}}%</p>
      </div>
      <div class="fangke-item">
        <p>当天IOS访客数：{{fangke.visitCountIos}}</p>
      </div>
      <div class="fangke-item">
        <p>当天IOS访客新注册：{{fangke.registCountIos}}</p>
      </div>
      <div class="fangke-item">
        <p>当天IOS访客转化率：{{fangke.conversionRateIos }}%</p>
      </div>
      <div class="fangke-item">
        <p>当天Android访客数：{{fangke.visitCountAndroid}}</p>
      </div>
      <div class="fangke-item">
        <p>当天Android访客新注册：{{fangke.registCountAndroid}}</p>
      </div>
      <div class="fangke-item">
        <p>当天Android访客转化率：{{fangke.conversionRateAndroid}}%</p>
      </div>
      <div class="fangke-item">
        <p>最近5分钟登录访客数量：{{fangke.loginCount}}</p>
      </div>
      <div class="fangke-item">
        <p></p>
      </div>
      <div class="fangke-item">
      </div>
    </div>

    <div class="chart-target">
      <div class="chart-target-2">
        <div id="main" style="width: 1000px;height:500px;" class="main"></div>
      </div>
    </div>

    <h4 class="table-h">当天访客来源渠道分布</h4>
    <el-table :data="tableData" border :summary-method="getSummaries" show-summary style=" margin-top: 20px">
      <el-table-column prop="channle" label="渠道" min-width="120" align="center">
        <template slot-scope="scope">
          {{scope.row.channle}}-{{scope.row.channleName}}
        </template>
      </el-table-column>
      <el-table-column prop="count" label="人数" align="center" min-width="120">
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
import { visitordata } from "@/apis/api";
import { Utils, Dates, getStore } from "@/apis/mUtils";
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
      filters: {
        value1: ""
      },
      users: [],
      fangke: [],
      tableData: [],
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      }
    };
  },
  methods: {
    getSummaries(param) {
      const { columns, data } = param;
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = "合计";
          return;
        }
        const values = data.map(item => Number(item[column.property]));
        if (!values.every(value => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr);
            if (!isNaN(value)) {
              return prev + curr;
            } else {
              return prev;
            }
          }, 0);
          sums[index] += " 人";
        } else {
          sums[index] = "N/A";
        }
      });

      return sums;
    },

    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById("main"));
      // 绘制图表
      myChart.setOption({
        title: {
          text: "访客在线数量走势图"
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: this.users.map(function(item) {
            return item.createDate;
          })
        },
        legend: {
          data: ["注册量"]
        },
        tooltip: {
          trigger: "axis"
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            name: "在线数量",
            type: "line",
            stack: "总量1",
            data: this.users.map(function(item) {
              return item.visitorCount;
            }),
            itemStyle: {
              normal: {
                color: "#48D1CC",
                lineStyle: {
                  color: "#48D1CC"
                }
              }
            }
          }
        ]
      });
    },
    // 获取用户列表：
    getUsers() {
      let para = {
        date: this.filters.value1
      };
      visitordata(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
        console.log(data);
        this.users = data.visitorOnlineStatisticsDtoList;
        this.tableData = data.visitorChannleStatisticsDtoList;
        this.fangke = data.visitorStatisticsDto;
        this.drawLine();
      });
    },
    getUs() {
      this.users = [];
      this.tableData = [];
      this.fangke = [];
      this.getUsers();
    }
  },
  mounted() {
    this.filters.value1 = Dates.formatDate(Date.now(), "yyyy-MM-dd");
    this.getUsers();
  }
};
</script>




<style lang="less" scoped>
.visi {
  margin: 0 auto;
  width: 93%;
  padding-bottom: 60px;
}

.fangke {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  .fangke-item {
    box-sizing: border-box;
    width: 33.3333%;
    height: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid #ccc;
  }
}
.chart-target {
  margin-top: 90px;
}

.table-h {
  margin-top: 60px;
  text-align: center;
}
</style>
