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
      <el-table-column label="用户信息">
        <template slot-scope="scope">---{{ scope.row.book}}</template>
      </el-table-column>
      <el-table-column label="来源途径" align="center" width="200">
        <template slot-scope="scope">---{{ scope.row.book }}</template>
      </el-table-column>
      <el-table-column label="数量" align="center" width="200">
        <template slot-scope="scope">---{{ scope.row.id }}</template>
      </el-table-column>
      <el-table-column label="时间" align="center" width="200">
        <template slot-scope="scope">---{{ scope.row.id }}</template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="paging">
      <el-pagination
        background
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="10"
        layout="total, prev, pager, next, jumper"
        :total="total" />
    </div>
  </section>
</template>
<script>
export default {
  components: {},
  props:['fetchHandle','title'],
  data() {
    return {
      currentPage: 1,
      total: 0,
      pageSize: 10,
      list: [],
      listLoading: false
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let para = {
        uid: this.filters.uid,
        name: this.filters.nickName,
        telephone: this.filters.phoneNum,
        pageNo: this.currentPage,
        pageSize: 10
      };
      this.fetchHandle(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        this.users = res.data.data.data;
        this.total = res.data.data.count;
        if (this.$refs.userin) {
          this.$refs.userin.Userlist();
        }
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
</style>
