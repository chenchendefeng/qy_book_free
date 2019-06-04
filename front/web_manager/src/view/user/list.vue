
<template>
  <section>
    <!--工具条-->
    <div class="operations">
      <el-form :inline="true" :model="filter">
        <el-form-item label="用户信息：" prop="unionMsg">
          <el-input v-model="filter.unionMsg" placeholder="请输入ID/手机号码/红包码"/>
        </el-form-item>
        <el-form-item label="用户类型：">
          <el-select v-model="filter.userType" placeholder="筛选条件">
            <el-option label="游客" value="'visitor'"/>
            <el-option label="注册用户" value="'register'"/>
            <el-option label="会员" value="'vip'"/>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">检索用户</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name="table-hd"
    >
      <el-table-column label="用户信息">
        <template slot-scope="scope">
          <span class="title" @click="go(scope.row)">{{ `${scope.row.cuName}(${scope.row.cuId})` || '--'}}</span>
        </template>
      </el-table-column>
      <el-table-column label="注册时间" align="center" width="200">
        <template slot-scope="scope">{{ scope.row.regDate || '--'}}</template>
      </el-table-column>
      <el-table-column label="客户端类型" align="center" width="200">
        <template slot-scope="scope">{{ scope.row.source || '--'}}</template>
      </el-table-column>
      <el-table-column label="渠道来源" align="center" width="150">
        <template slot-scope="scope">{{ scope.row.registChannel || '--'}}</template>
      </el-table-column>
      <el-table-column label="最近上线时间" width="200" align="center">
        <template slot-scope="scope">{{scope.row.lineTime || '--' }}</template>
      </el-table-column>
      <el-table-column label="操作" width="100" align="center">
        <template slot-scope="scope">
          <a @click="go(scope.row)">查看详情</a>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="paging" v-if="count">
      <el-pagination
        background
        @current-change="handleCurrentChange"
        :current-page="pageNo"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="count"
      />
    </div>
  </section>
</template>

<script>
import { getUsers } from "@/apis/user";
import { setStore } from "@/apis/mUtils";
export default {
  data() {
    return {
      pageNo: 1,
      count: 0,
      pageSize: 10,
      filter: {
        unionMsg: "",
        userType: ""
      },
      list: [],
      listLoading: false
    };
  },
  // 获取用户数据
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.listLoading = true;
      let param = Object.assign({},this.filter,{
        pageNo: this.pageNo,
        pageSize: this.pageSize
      })
      getUsers(param).then(({ data })=>{
        this.list = data.data.data
        this.count = data.data.count
        this.listLoading = false;
      })
    },
    handleCurrentChange(val) {
      this.pageNo = val;
      this.fetchData();
    },
    search() {
      this.pageNo = 1;
      this.fetchData();
    },
    go(data){
      let str = data.cuName ? ` > ${data.cuName}` : ''
      this.$router.push({
        path: `/user/detail/${data.cuId}`
      })
      setStore('metaTitle',`用户管理${str}`)
    }
  }
};
</script>
<style lang="less" scoped>
.title{
  color:#409EFF; 
  cursor: pointer;
}
</style>