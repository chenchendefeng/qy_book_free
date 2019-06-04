<template>
  <section class="personal">
    <!--工具条-->
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
      header-cell-class-name="table-hd"
    >
      <el-table-column label="图标" min-width="120">
        <template slot-scope="scope">
          <img width="70" height="70" :src="scope.row.picUrl" class="personal-icon" />
        </template>
      </el-table-column>
      <el-table-column label="主标题" min-width="140">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.mainTitle || '--'}}</span>
          <br/>
          RGB值：{{ scope.row.mainTitleColor || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="副标题" align="center" min-width="140">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.subTitle || '--' }}</span>
          <br/>
          RGB值：{{ scope.row.subTitleColor || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="次标题" align="center" min-width="140">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.threeTitle || '--' }}</span>
          <br/>
          RGB值：{{ scope.row.threeTitleColor || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="跳转去向" align="center" min-width="130">
        <template slot-scope="scope">{{ scope.row.directionPath || '--' }}</template>
      </el-table-column>
      <el-table-column label="更新时间" min-width="130" align="center">
        <template slot-scope="scope">{{scope.row.updateDate || '--' }}</template>
      </el-table-column>
      <el-table-column label="排序" min-width="80" align="center">
        <template slot-scope="scope">{{ scope.row.sort }}</template>
      </el-table-column>
      <el-table-column label="状态" min-width="80" align="center">
        <template slot-scope="scope">{{ scope.row.status ? '上架' : '下架' }}</template>
      </el-table-column>
      <el-table-column label="操作" min-width="90" align="center">
        <template slot-scope="scope">
          <a @click="go(scope.row.id,scope.row.mainTitle)">查看详情</a>
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
import { getPersonals } from "@/apis/personal";
import { setStore } from "@/apis/mUtils";
export default {
  components: {},
  data() {
    return {
      pageNo: 1,
      filter:{
        status: 1
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
        status: this.filter.status,
        pageNo: this.pageNo,
        pageSize: 10
      };
      getPersonals(para).then(({ data }) => {
        this.list = data.data.data;
        this.total = data.data.count;
        this.listLoading = false;
      });
    },
    go(id,title){
      let str = id ? ` > ${title}` : ' > 新增'
      let path = id ? `/module/personal/detail/${id}` : `/module/personal/detail`
      this.$router.push({
        path: path
      })
      setStore('metaTitle', `个人中心${str}`)
    }
  }
};
</script>
<style lang="less" scoped>
.personal{
  .personal-icon{
    border:solid 1px #ccc;
  }
  .operations{
    .right{
      float: right;
    }
  }
  .title{
    color:#409EFF;
    display: inline-block;
    margin-bottom: 6px;
  }
}

</style>
