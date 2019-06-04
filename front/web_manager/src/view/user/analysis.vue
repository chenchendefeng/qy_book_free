<template>
  <section>
    <!-- 工具条 -->
    <div class="operations">
      <el-form :inline="true" :model="filters">
        <el-form-item label="开始时间：">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.startDate"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
            :picker-options="pickerOptionsStart"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间：">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.endDate"
            align="center"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
            :picker-options="pickerOptionsEnd"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="fetchData">查询</el-button>
        </el-form-item>
      </el-form>
    </div>

    <!-- 表格数据 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name="table-hd"
    >
      <el-table-column label="时间">
        <template slot-scope="scope">---{{ scope.row.book}}</template>
      </el-table-column>
      <el-table-column label="金豆今日发放量（个）" align="center" width="200">
        <template slot-scope="scope"><span class="show-list-item" @click="showDialog">333333333</span>{{ scope.row.book }}</template>
      </el-table-column>
      <el-table-column label="金豆今日消耗量（个）" align="center" width="200">
        <template slot-scope="scope">---{{ scope.row.id }}</template>
      </el-table-column>
      <el-table-column label="金豆今日兑换量（个）" align="center" width="200">
        <template slot-scope="scope">---{{ scope.row.book }}</template>
      </el-table-column>
      <el-table-column label="红包今日发放量（元）" width="200" align="center">
        <template slot-scope="scope">---{{scope.row.book }}</template>
      </el-table-column>
      <el-table-column label="红包今日兑换量（元）" width="200" align="center">
        <template slot-scope="scope">---{{scope.row.book }}</template>
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

    <!-- 弹窗 -->
    <el-dialog title="" :visible.sync="visible">
      <analysisList />
    </el-dialog>
  </section>
</template>
<script>
import { getUserList } from "@/apis/user";
import analysisList from "@/components/user/analysisList";

export default {
  components:{
    analysisList
  },
  data() {
    return {
      pageNo: 1,
      pageSize: 10,
      count: 0,
      filters: {
        startDate: "",
        endDate: ""
      },
      list: [{}],
      listLoading: false,
      visible: false,
      pickerOptionsStart: {
        disabledDate: time => {
          return time.getTime() > Date.now() - 8.64e7;
        }
      },
      pickerOptionsEnd: {
        disabledDate: time => {
          if (this.filters.startDate != "") {
            let moth = new Date(this.filters.startDate).getTime();
            return (
              time.getTime() <= moth || time.getTime() > Date.now() - 8.64e7
            );
          }
        }
      }
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
        userName: this.filters.name,
        pageSize: 10,
        pageNo: this.pageNo
      };
      this.users = [{ id: 1 }];
      this.listLoading = false;
    },
    showDialog(){
      this.visible = true
    }
  }
};
</script>

<style lang="less" scoped>
.show-list-item{
  color: #409EFF;
  cursor: pointer;
}
.paging {
  margin: 10px auto;
  text-align: center;
}
</style>