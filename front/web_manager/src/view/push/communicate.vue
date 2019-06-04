<template>
  <section class="communicate">
    <div class="operations">
      <router-link :to="`/push/communicate/add`">
        <el-button type="primary" icon="el-icon-plus">新增</el-button>
      </router-link>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name="table-hd"
    >
      <el-table-column label="头像" align="center">
        <template slot-scope="scope">
          <img class="avatar" :src="scope.row.faceUrl" />
        </template>
      </el-table-column>
      <el-table-column label="昵称" align="center">
        <template slot-scope="scope">{{ scope.row.nick || '--' }}</template>
      </el-table-column>
      <el-table-column label="类型" align="center">
        <template slot-scope="scope">{{ scope.row.type ? '表示机器人帐号' : '表示普通帐号' || '--' }}</template>
      </el-table-column>
      <el-table-column label="状态" align="center">
        <template slot-scope="scope">{{ scope.row.status ? '已启用' : '未启用' }}</template>
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
import { getCommunicateAcount } from "@/apis/push";
export default {
  data() {
    return {
      pageNo: 1,
      total: 0,
      pageSize: 10,
      list: [],
      listLoading: false
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    handleCurrentChange(val) {
      this.pageNo = val;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let para = {
        pageNo: this.pageNo,
        pageSize: this.pageSize
      };
      getCommunicateAcount(para).then(({ data }) => {
        this.list = data.data.data;
        this.total = data.data.count;
        this.listLoading = false;
      });
    }
  }
};
</script>
<style lang="less" scoped>
.communicate{
  .avatar{
    width:100px;
    height: 100px;
    border: solid 1px #ccc;
  }
}
</style>

