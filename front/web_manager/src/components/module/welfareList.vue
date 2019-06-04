<template>
  <section class="welfare-list">
    <!--工具条-->
    <div class="operations">
      <el-form :inline="true" :model="filter">
        <el-form-item>
          <el-select v-model="filter.status" placeholder="状态">
            <el-option label="全部" value="" />
            <el-option label="上架" value="1" />
            <el-option label="下架" value="0" />
          </el-select>
          <el-select v-model="filter.rewardType" placeholder="奖励类型">
            <el-option label="全部" value="" />
            <el-option label="现金" value="rmb" />
            <el-option label="金豆" value="gold" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="serach">搜索</el-button>
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
      header-cell-class-name="table-hd"
    >
      <el-table-column label="福利类型" width="90">
        <template slot-scope="scope">
          <span class="title">{{ welfare[scope.row.type] || '--'}}</span>
        </template>
      </el-table-column>
      <el-table-column label="奖励类型" align="center"  width="90">
        <template slot-scope="scope">
          {{ scope.row.rewardType === 'rmb' ? '现金' : '金豆' || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="奖励数量" align="center"  width="90">
        <template slot-scope="scope">
          {{scope.row.minNum}} ~ {{scope.row.maxNum}}{{ scope.row.rewardType === 'rmb' ? '元'  : '金豆'}}
        </template>
      </el-table-column>
      <el-table-column label="主标题"  align="center">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.mainTitle || '--'}}</span>
          <br/>
          RGB值：{{ scope.row.mainTitleColor || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="副标题" align="center" width="140">
        <template slot-scope="scope">
          <span class="title">{{ scope.row.subTitle || '--' }}</span>
          <br/>
          RGB值：{{ scope.row.subTitleColor || '--' }}
        </template>
      </el-table-column>
      <el-table-column label="跳转去向" align="center" width="100">
        <template slot-scope="scope">{{ scope.row.skipPage || '--' }}</template>
      </el-table-column>
      <el-table-column label="按钮文案" width="80" align="center">
        <template slot-scope="scope">{{scope.row.buttonTex || '--' }}</template>
      </el-table-column>
      <el-table-column label="图标文案" width="80" align="center">
        <template slot-scope="scope">{{scope.row.iconTex || '--' }}</template>
      </el-table-column>
      <el-table-column label="最近更新时间" width="140" align="center">
        <template slot-scope="scope">{{scope.row.updateTime || '--' }}</template>
      </el-table-column>
      <el-table-column label="排序" width="70" align="center">
        <template slot-scope="scope">{{ scope.row.sort }}</template>
      </el-table-column>
      <el-table-column label="状态" width="70" align="center">
        <template slot-scope="scope">{{ scope.row.status ? '上架' : '下架' }}</template>
      </el-table-column>
      <el-table-column label="操作" width="100" align="center">
        <template slot-scope="scope">
          <a @click="go(scope.row.id)">查看详情</a>
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
import { getWelfareList } from "@/apis/welfare";
import { setStore } from "@/apis/mUtils";
export default {
  components: {},
  props: ["type"],
  data() {
    return {
      pageNo: 1,
      filter:{},
      welfare: {
        novice: '新人福利',
        read: '阅读福利',
        daily: '日常福利'
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
    serach(){
      this.pageNo = 1;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let para = {
        status: this.filter.status,
        type: this.type,
        rewardType: this.filter.rewardType,
        pageNo: this.pageNo,
        pageSize: 10
      };
      getWelfareList(para).then(({ data }) => {
        this.list = data.data.data;
        this.total = data.data.count;
        this.listLoading = false;
      });
    },
    go(id){
      let obj = {
        novice: '新人福利',
        read: '阅读福利',
        daily: '日常福利'
      }
      let path = id ? `/module/welfare/detail/${this.type}/${id}` : `/module/welfare/detail/${this.type}`
      this.$router.push({
        path: path
      })
      setStore('metaTitle','福利中心 > ' + obj[this.type])
    }
  }
};
</script>
<style lang="less" scoped>
.welfare-list{
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
