<template>
  <section class="goods">
    <div class="operations">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-select v-model="filters.paymentStatus" placeholder="状态">
            <el-option label="全部" value="" />
            <el-option label="未支付" :value="0" />
            <el-option label="支付完成" :value="1" />
            <el-option label="支付失败" :value="2" />
          </el-select>
        </el-form-item>
        <el-form-item label="创建时间：">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.createDateStart"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
            :picker-options="pickerOptionsStart"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="至">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.createDateEnd"
            align="center"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
            :picker-options="pickerOptionsEnd"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-input type="number" v-model="filters.cuId" placeholder="用户ID"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
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
      <el-table-column label="订单编号">
        <template slot-scope="scope">
          {{ scope.row.orderNum || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="购买用户" align="center" width="120">
        <template slot-scope="scope">
          <router-link class="title" :to="`/user/detail/${scope.row.cuId}`">{{ scope.row.cuId || '--' }}</router-link>
        </template>
      </el-table-column>
      <el-table-column label="会员商品" align="center" width="200">
        <template slot-scope="scope">
          {{ scope.row.goodsName || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="支付方式" align="center" width="80">
        <template slot-scope="scope">
          {{ scope.row.payMethod === 1 ? '微信': '' || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="支付金额" width="150" align="center">
        <template slot-scope="scope">
          {{(scope.row.goodsPrice/100).toFixed(2) || '--' }} 元
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="150" align="center">
        <template slot-scope="scope">
          {{ scope.row.createDate || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="支付时间" width="150" align="center">
        <template slot-scope="scope">
          {{ scope.row.payTime || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="状态" width="120" align="center">
        <template slot-scope="scope">
          {{ payStatus[scope.row.paymentStatus] }}
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <div class="paging" v-if="total">
      <el-pagination
        background
        @current-change="handleCurrentChange"
        :current-page="pageNo"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
  </section>
</template>
<script>
import { getBuyRecords } from "@/apis/member";
import { Dates } from "@/apis/mUtils";
export default {
  mounted(){
    this.filters.createDateStart = Dates.formatDate(
      Date.now() - 8.64e7 * 6,
      "yyyy-MM-dd 00:00:00"
    );
    this.filters.createDateEnd = Dates.formatDate(Date.now(), "yyyy-MM-dd HH:mm:ss");
    this.fetchData()
  },
  data() {
    return {
      pageNo:1,
      pageSize:10,
      total: 0,
      payStatus:{
        0: '未支付',
        1: '支付完成',
        2: '支付失败'
      },
      filters: {
        paymentStatus: '',
        createDateStart: '',
        createDateEnd: '',
        cuId: ''
      },
      list: [],
      listLoading: false,
      pickerOptionsStart: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      },
      pickerOptionsEnd: {
        disabledDate: time => {
          if (this.filters.createDateStart != "") {
            let moth = new Date(this.filters.createDateStart).getTime();
            return (
              time.getTime() <= moth  - 8.64e7 || time.getTime() > Date.now()
            );
          }
        }
      }
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.pageNo = val;
      this.fetchData();
    },
    search() {
      this.pageNo = 1;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true
      let para = Object.assign({},this.filters,{
        pageNo: this.pageNo,
        pageSize: this.pageSize
      })
      getBuyRecords(para).then(({ data }) => {
        this.list = data.data.data;
        this.total = data.data.count;
        this.listLoading = false;
      });
    }
  }
};
</script>
<style lang="less" scoped>
.goods{
  .title{
    color:#409EFF;
    cursor: pointer;
  }
}
</style>
