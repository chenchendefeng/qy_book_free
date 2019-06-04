<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-input v-model="filters.cBID" placeholder="输入书籍ID查询" prefix-icon="el-icon-search" ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="filters.uid" placeholder="输入用户ID" prefix-icon="el-icon-search" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></el-input>
        </el-form-item>

        <br>
        <el-form-item label="开始时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="结束时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value2" align="center" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions1">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getUs">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">

      <el-table-column prop="cBID" label="书籍ID" width="150" show-overflow-tooltip align="center">
      </el-table-column>
      <el-table-column prop="bookName" label="书名" min-width="120" align="center">
      </el-table-column>
      <el-table-column prop="authorname" label="作者" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="分类" min-width="80" align="center">
        <template slot-scope="scope">
          <p v-for="(item,index) of scope.row.categoryList" :key="index">{{item}}</p>
        </template>
      </el-table-column>
      <el-table-column prop="chapterCount" label="购买章节" min-width="80" align="center">
      </el-table-column>
      <el-table-column prop="amount" label="支付书币" min-width="100" align="center">
      </el-table-column>
      <el-table-column prop="customerName" label="用户" min-width="120" align="center">
        <template slot-scope="scope">
          <el-button size="small" type="text" @click="handleEdit(scope.$index, scope.row)">{{scope.row.customerName}}</el-button>
        </template>
      </el-table-column>
      <el-table-column prop="updateTime" label="时间" min-width="120" align="center">
      </el-table-column>
    </el-table>

    <!--用户详情-->
    <el-dialog title="用户详情" :visible.sync="FormVisible" width="1000px" @closed="close">
      <particular :uid="uid" @hiden="show" ref="userin"></particular>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import { bookOrderMgrlist } from "@/apis/api";
import { Utils, Dates } from "@/apis/mUtils";
import particular from "../common/particular";
import { mapState, mapMutations } from "vuex";
export default {
  components: {
    particular
  },
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      pageSize: 10,
      //搜索
      filters: {
        uid: "",
        cBID: "",
        value1: "",
        value2: ""
      },
      uid: "",
      //具体列表
      users: [],
      listLoading: false, //刷新
      FormVisible: false,
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      },
      pickerOptions1: {
        disabledDate: time => {
          if (this.value1 != "") {
            let moth = new Date(this.filters.value1).getTime();
            return time.getTime() <= moth || time.getTime() > Date.now();
          }
        }
      }
    };
  },
  methods: {
    ...mapMutations(["rmoves"]),
    //子隐藏
    show() {
      this.FormVisible = false;
    },
    //关闭弹窗时候触发
    close() {
      this.$refs.userin.Userlist();
      this.getUsers();
    },
    //y用户详情
    handleEdit(index, row) {
      this.uid = row.uid;
      // console.log(this.uid)
      this.FormVisible = true;
    },
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getUsers();
      console.log(`当前页: ${val}`);
    },

    getUs() {
      this.currentPage = 1;
      this.getUsers();
    },
    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        pageNo: this.currentPage,
        pageSize: 10, //每页个数
        uid: this.filters.uid, //关键字
        cBID: this.filters.cBID,
        startDate: this.filters.value1,
        endDate: this.filters.value2
      };
      bookOrderMgrlist(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取失败`);
            return false;
          }
          this.users = res.data.data.data;
          this.total = res.data.data.count;
          this.listLoading = false;
        })
        .catch(() => {
          this.$message.error("请求错误");
          this.listLoading = false;
        });
    }
  },

  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.formatDate(
      Date.now() - 8.64e7 * 14,
      "yyyy-MM-dd 00:00:00"
    );
    this.filters.value2 = Dates.formatDate(Date.now(), "yyyy-MM-dd HH:mm:ss");
    this.getUsers();
  },
  computed: {
    currentuid() {
      return this.$store.state.bookuid;
    }
  },
  watch: {
    currentuid(e) {
      if (this.$store.state.book == "third") {
        this.filters.uid = e;
        // console.log(e, "书籍售卖查询");
      }
    }
  },
  destroyed() {
    // this.rmoves();
    // this.FormVisible= false;
  }
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;
  margin-bottom: 50px;
  text-align: center;
}
.toolbar {
  margin-bottom: 30px;
}
</style>