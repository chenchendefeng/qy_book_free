<template>
  <section class="gifts">
    <div class="operations">
      <el-form :inline="true" :model="filter">
        <el-form-item>
          <el-select v-model="filter.status" placeholder="状态">
            <el-option label="全部" value="" />
            <el-option label="上架" :value="1" />
            <el-option label="下架" :value="0" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filter.exchangeType" placeholder="礼品类型">
            <el-option label="全部" value="" />
            <el-option label="金豆" :value="'gold'" />
            <el-option label="人民币" :value="'rmb'" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
        </el-form-item>
        <el-form-item class="right">
          <el-button type="primary" @click="go(0)" icon="el-icon-plus">新增</el-button>
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
      <el-table-column label="礼品名称">
        <template slot-scope="scope">
          <ul>
            <li class="title">{{scope.row.name || '--'}}</li>
            <li>礼品ID:{{scope.row.id || '--'}}</li>
            <li>更新时间：{{scope.row.updateTime || '--'}}</li>
          </ul>
        </template>
      </el-table-column>
      <el-table-column label="礼品类型" align="center" width="120">
        <template slot-scope="scope">
          {{ (scope.row.exchangeType === 'gold' ? '金豆' : '人民币') || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="兑换条件" align="center" width="220">
        <template slot-scope="scope">
          {{ exchangeConditon(scope.row) }}
        </template>
      </el-table-column>
      <el-table-column label="提示角标" align="center" width="100">
        <template slot-scope="scope">
          {{ scope.row.marker || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="需消耗量" width="120" align="center">
        <template slot-scope="scope">
          {{scope.row.cost }}
        </template>
      </el-table-column>
      <el-table-column label="状态" width="120" align="center">
        <template slot-scope="scope">
          {{ scope.row.status ? '上架' : '下架' }}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120" align="center">
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
      ></el-pagination>
    </div>
  </section>
</template>
<script>
import { getGifts } from "@/apis/gifts"
import { setStore } from "@/apis/mUtils";
export default {
  data() {
    return {
      filter: {
        status: 1,
        exchangeType: ''
      },
      list: [],
      listLoading: false,
      pageNo:1,
      pageSize:10,
      count: 0,
    };
  },
  created(){
    this.fetchData()
  },
  methods: {
    handleCurrentChange(val){
      this.pageNo = val
      this.fetchData()
    },
    search(){
      this.pageNo = 1
      this.fetchData()
    },
    exchangeConditon(data){
      let str = ''
      if(data.requirement === 'VIP'){
        str = '会员'
      }
      if(data.requirement === 'readTime'){
        str = `阅读满${data.requirementNumber}分钟`
      }
      if(data.requirement === 'all'){
        str = `无限制`
      }
      return str
    },
    fetchData() {
      this.listLoading = true
      getGifts(this.filter).then(({ data })=> {
        this.list = data.data.data
        this.listLoading = false
        this.count = data.data.count
      })
    },
    go(data){
      let id = data.id
      let str = id ? ` > ${data.name}` : ' > 新增'
      let path = id ? `/gifts/detail/${id}` : `/gifts/detail`
      this.$router.push({
        path: path
      })
      setStore('metaTitle',`礼品管理${str}`)
    }
  }
};
</script>
<style lang="less" scoped>
.gifts{
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
