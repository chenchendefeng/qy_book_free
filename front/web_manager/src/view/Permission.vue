<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.name" placeholder="查询" prefix-icon="el-icon-search" style="width: 150px;"></el-input>

        </el-form-item>
        <el-form-item>
          <span class="demonstration">开始时间：</span>
          <span class="demonstration">值：{{ value1 }}</span>
          <el-date-picker v-model="value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <span class="demonstration">结束时间</span>
          <span class="demonstration">值：{{ value2 }}</span>
          <el-date-picker v-model="value2" align="center" type="date" placeholder="选择日期" value-format="yyyy-MM-dd" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions1">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-select v-model="filters.rids" placeholder="全部" style="width: 160px;">
            <el-option :label="item.roleName" :value="item.id" v-for="item of role" :key=item.id>
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getUsers">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">
      <el-table-column label="序号" type="index" width="50" align="center">
      </el-table-column>
      <el-table-column prop="id" label="支付时间" width="150" show-overflow-tooltip align="center">
      </el-table-column>
      <el-table-column prop="userName" label="支付金额" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="金额（IOS）" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="金额（Android）" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="交易笔数" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="IOS笔数" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="Android笔数）" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="ios-syore" min-width="80" align="center">
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
        rids: ""
      },
      //具体列表
      users: [],
      ids: -1,
      listLoading: false, //刷新
      value1: "",
      value2: "",
      role: [
        {
          roleName: "一号",
          id: 1
        },
        {
          roleName: "二号",
          id: 2
        }
      ],
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
</style>