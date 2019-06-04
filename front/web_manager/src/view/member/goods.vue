<template>
  <section class="goods">
    <div class="operations">
      <el-form :inline="true" :model="filter">
        <el-form-item>
          <el-select v-model="filter.saleStatus" placeholder="状态">
            <el-option label="全部" value="" />
            <el-option label="上架" :value="1" />
            <el-option label="下架" :value="0" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
        </el-form-item>
        <el-form-item class="right">
         <el-button @click="go(0)" type="primary" icon="el-icon-plus">新增</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name = "table-hd">
      <el-table-column label="商品信息" min-width="200">
        <template slot-scope="scope">
          <ul>
            <li class="title">{{scope.row.goodsName || '--'}}</li>
            <li>商品ID:{{scope.row.id}}</li>
            <li>创建时间：{{scope.row.createTime || '--'}}</li>
          </ul>
          {{ scope.row.book}}
        </template>
      </el-table-column>
      <el-table-column label="价格" align="center" min-width="110">
        <template slot-scope="scope">
          {{ (scope.row.goodsPrice / 100).toFixed(2) || '--' }}元
        </template>
      </el-table-column>
      <el-table-column label="数量" align="center" min-width="110">
        <template slot-scope="scope">
          {{ scope.row.goodsNum || '--'}}天
        </template>
      </el-table-column>
      <el-table-column label="提示角标" align="center" min-width="110">
        <template slot-scope="scope">
          {{ scope.row.noticeMsg || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="副标题" align="center" min-width="150">
        <template slot-scope="scope">
          {{scope.row.goodsMsg || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" min-width="100">
        <template slot-scope="scope">
          {{ scope.row.saleStatus ? '上架' : '下架' }}
        </template>
      </el-table-column>
      <el-table-column label="操作" min-width="110" align="center">
        <template slot-scope="scope">
          <a @click="go(scope.row.id,scope.row.goodsName)" >查看详情</a>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="paging" v-if="total">
      <el-pagination
        background
        @current-change="handleCurrentChange"
        :current-page="pageNo"
        :page-size="10"
        layout="total, prev, pager, next, jumper"
        :total="total"
      />
    </div>
  </section>
</template>
<script>
import { getGoods } from "@/apis/member";
import { setStore } from "@/apis/mUtils";
export default {
  data() {
    return {
      pageNo: 1,
      filter:{
        saleStatus: 1
      },
      total: 0,
      pageSize: 10,
      list: [],
      listLoading: false
    };
  },
  created(){
    this.fetchData()
  },
  methods: {
    handleCurrentChange(val) {
      this.pageNo = val;
      this.fetchData();
    },
    search(){
      this.pageNo = 1;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let para = {
        saleStatus: this.filter.saleStatus,
        pageNo: this.pageNo,
        pageSize: 10
      };
      getGoods(para).then(({ data }) => {
        this.list = data.data.data;
        this.total = data.data.count;
        this.listLoading = false;
      });
    },
    go(id,title){
      let str = id ? ` > ${title}` : ' > 新增'
      let path = id ? `/member/goods/detail/${id}` : `/member/goods/detail/`
      this.$router.push({
        path: path
      })
      setStore('metaTitle','商品管理' + str)
    }
  }
};
</script>
<style lang="less" scoped>
.goods{
  ul{
    line-height: 30px;
    .title{
      color:#409EFF
    }
  }
  .right{
    float: right;
  }
}
</style>
