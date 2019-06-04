<template>
  <section class="detail-list">
    <h3>{{title}}</h3>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name = "table-hd">
      <el-table-column label="时间">
        <template slot-scope="scope">{{ scope.row.createTime}}</template>
      </el-table-column>
      <el-table-column label="来源途径" align="center" width="300">
        <template slot-scope="scope">{{ scope.row.title }}</template>
      </el-table-column>
      <el-table-column label="数量" align="center" width="200">
        <template slot-scope="scope">{{ type === 'gold' ?  `${scope.row.amount}个` : `${(scope.row.amount/100).toFixed(2)}元`}}</template>
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
        :total="count" />
    </div>
  </section>
</template>
<script>
export default {
  components: {},
  props:['fetchHandle','title','type'],
  data() {
    return {
      pageNo: 1,
      count: 0,
      pageSize: 5,
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
    fetchData() {
      this.listLoading = true;
      let para = {
        cuId: this.$route.params.id,
        currentType: this.type,
        pageNo: this.pageNo,
        pageSize: this.pageSize
      };
      this.fetchHandle(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        this.list = res.data.data.data;
        this.count = res.data.data.count;
        this.listLoading = false;
      });
    }
  }
};
</script>
<style lang="less" scoped>
.detail-list{
  width:700px;
  h3{
    margin: 30px 0 10px;
    font-size: 13px;
    color:#666;
  }
}
.paging {
  text-align: left;
}
</style>
