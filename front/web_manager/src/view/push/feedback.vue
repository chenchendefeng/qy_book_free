<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">

        <el-form-item label="状态：">
          <el-select v-model="filters.rids" placeholder="全部" style="width: 120px;">
            <el-option label="未处理" :value=0>
            </el-option>
            <el-option label="已处理" :value=1>
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="开始时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="结束时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value2" align="center" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions1">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-input v-model="filters.name" placeholder="用户ID" prefix-icon="el-icon-search" style="width: 140px;" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getUsers">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">
      <el-table-column prop="id" label="时间" min-width="100" show-overflow-tooltip align="center">
      </el-table-column>
      <el-table-column prop="userName" label="用户消息" min-width="80" align="center">
        <!-- <template slot-scope="scope">
          <el-button size="small" type="text">喊打下</el-button>
        </template> -->
      </el-table-column>

      <el-table-column prop="loginName" label="文本消息" min-width="120" align="center">
        <!-- <template slot-scope="scope">
          <div class="tabtext">
            <p>噢噢噢噢</p>
            <el-popover placement="bottom" trigger="click">
              <el-table :data="gridData" height="250" border>
                <el-table-column width="200" property="date" label="消息时间" align="center"></el-table-column>
                <el-table-column width="250" property="name" label="消息内容" align="center"></el-table-column>
              </el-table>
              <div class="poptxt">
                <el-button >回复</el-button>
                <el-button >忽略</el-button>
              </div>
              <el-button slot="reference" type="text" style="color: red;">条数：2</el-button>
            </el-popover>
          </div>
        </template> -->
      </el-table-column>

      <el-table-column prop="loginName" label="消息图片" min-width="80" align="center">
        <!-- <template slot-scope="scope">
          <img :src="`static/img/img.jpg`" alt="" style="width: 80px;height: 80px; ">
        </template> -->
      </el-table-column>
      <el-table-column prop="loginName" label="状态" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="处理结果" min-width="120" align="center">
      </el-table-column>
      <el-table-column label="操作" min-width="120" align="center">
        <template slot-scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">回复</el-button>
          <el-button size="small"  @click="handleSettings(scope.$index, scope.row)">忽略</el-button>
        </template>
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
import { getUserList } from "@/apis/api";
import { Utils, Dates } from "@/apis/mUtils";
export default {
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        name: "",
        rids: 1,
        value1: "",
        value2: ""
      },
      gridData: [
        {
          date: "21312312312",
          name: "小虎小虎小虎",
          address: "删除"
        },
        {
          date: "21312312312",
          name: "小虎小虎小虎",
          address: "删除"
        },
        {
          date: "21312312312",
          name: "小虎小虎小虎",
          address: "删除"
        },
        {
          date: "21312312312",
          name: "小虎小虎小虎",
          address: "删除"
        },
        {
          date: "21312312312",
          name: "小虎小虎小虎",
          address: "删除"
        },
        {
          date: "21312312312",
          name: "小虎小虎小虎",
          address: "删除"
        }
      ],
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
          if (this.value1 != "") {
            let moth = new Date(this.value1).getTime();
            return (
              time.getTime() <= moth || time.getTime() > Date.now() - 8.64e7
            );
          }
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

    handleEdit() {
      this.$prompt("", "请输入回复内容", {
        confirmButtonText: "发送",
        cancelButtonText: "取消",
        inputPlaceholder: "请输入",
        center: true,
        inputPattern: /\S/,
        inputErrorMessage: "输入不能为空"
      })
        .then(({ value }) => {
          this.$message({
            type: "success",
            message: "发送的消息为: " + value
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    handleSettings() {},

    open3() {},

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        userName: this.filters.name, //关键字
        pageSize: 10,
        pageNo: this.currentPage
      };
      this.users = [{ id: 1 }];
      this.listLoading = false;
    }
  },

  // 获取用户数据
  mounted() {
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
.tabtext {
  // display: flex;
  // flex-direction: column;
  span {
    color: red;
    cursor: pointer;
  }
}
.poptxt {
  display: flex;
  justify-content: center;
  margin-top: 10px;
  // button {
  //   // width: 100px;
  // }
}
</style>