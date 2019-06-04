<template>
  <section class="zone-list">
    <!--工具条-->
    <div class="operations">
      <el-form :inline="true" :model="filter">
        <el-form-item label="上架状态：">
          <el-select v-model="filter.status">
            <el-option label="全部" value="" />
            <el-option label="上架" value="1" />
            <el-option label="下架" value="0" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="serach">搜索</el-button>
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
      <el-table-column label="主标题">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.title || '--'}}</span>
          <br/>
          RGB值：{{ scope.row.titleRGB || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="副标题" align="center" width="220">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.title2 || '--' }}</span>
          <br/>
          RGB值：{{ scope.row.title2RGB || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="书籍数量" align="center" width="140">
        <template slot-scope="scope">{{ scope.row.bookList.length || '--' }}</template>
      </el-table-column>
      <el-table-column label="更新时间" width="200" align="center">
        <template slot-scope="scope">{{scope.row.updateTime || '--' }}</template>
      </el-table-column>
      <el-table-column label="排序" width="140" align="center">
        <template slot-scope="scope">{{ scope.row.displayOrder }}</template>
      </el-table-column>
      <el-table-column label="状态" width="140" align="center">
        <template slot-scope="scope">{{ scope.row.status ? '上架' : '下架' }}</template>
      </el-table-column>
      <el-table-column label="操作" width="140" align="center">
        <template slot-scope="scope">
          <a @click="go(scope.row.id,scope.row.title)" >查看详情</a>
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
import { getZoneList } from "@/apis/module";
import { setStore } from "@/apis/mUtils";
export default {
  components: {},
  props: ["fetchHandle","type"],
  data() {
    return {
      pageNo: 1,
      filter:{},
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
    serach(){
      this.pageNo = 1;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let para = {
        status: this.filter.status,
        subjectType: this.type,
        pageNo: this.pageNo,
        pageSize: 10
      };
      getZoneList(para).then(({ data }) => {
        this.list = data.data.data;
        this.total = data.data.count;
        this.listLoading = false;
      });
    },
    go(id,title){
      let obj = {
        boy: '男生专区管理',
        girl: '女生专区管理',
        recommend: '推荐专区管理'
      }
      let str = id ? ` > ${title}` : ' > 新增'
      let path = id ? `/module/zoneDetail/${this.type}/${id}` : `/module/zoneDetail/${this.type}`
      this.$router.push({
        path: path
      })
      setStore('metaTitle',obj[this.type] + str)
    }
  }
};
</script>
<style lang="less" scoped>
.zone-list{
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
