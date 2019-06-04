<template>
  <section class="list">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item label="发送状态：">
          <el-select v-model="filters.sendStatus" placeholder="发送状态" style="width: 120px;">
            <el-option :label="`全部`" :value="``"></el-option>
            <el-option :label="`未发送`" :value="0"></el-option>
            <el-option :label="`已发送`" :value="1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="开始时间：">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.value1"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
          ></el-date-picker>
        </el-form-item>

        <el-form-item label="结束时间：">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.value2"
            align="center"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd 23:59:59"
            format="yyyy 年 MM 月 dd 日"
          ></el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getU">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table
      :data="users"
      highlight-current-row
      v-loading="listLoading"
      style="width: 100%;"
      border
    >
      <el-table-column
        prop="createDate"
        label="操作时间"
        min-width="120"
        show-overflow-tooltip
        align="center"
      ></el-table-column>
      <el-table-column prop="toIdentifier" label="用户信息" min-width="80" align="center">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.toIdentifier"
            size="mini"
            @click="Details(scope.$index, scope.row)"
            type="text"
          >{{scope.row.toUserName}}({{scope.row.toIdentifier}})</el-button>
          <p v-else>所有人</p>
        </template>
      </el-table-column>
      <el-table-column prop="content" label="发送内容" min-width="120" align="center"></el-table-column>

      <el-table-column label="状态" prop="sendStatus" align="center">
        <template slot-scope="scope">
          <div v-if="scope.row.sendStatus == 0">
            <p>{{sendStatuss[scope.row.sendStatus]}}</p>
            <p>{{scope.row.sendTime}}</p>
            <el-button size="mini" @click="Cancel(scope.$index, scope.row, 2)" type="text">撤销</el-button>
          </div>

          <div v-else>{{sendStatuss[scope.row.sendStatus]}}</div>
        </template>
      </el-table-column>
      <el-table-column prop="createName" label="操作员" min-width="80" align="center"></el-table-column>
    </el-table>

    <!--用户详情-->
    <el-dialog title="用户详情" :visible.sync="FormVisible" width="1000px" @closed="close">
      <particular :uid="uid" @hiden="show" ref="userin"></particular>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="10"
        layout="total, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
  </section>
</template>

<script>
import {
  communicationMessagepage,
  communicationMessageupdateSendStatus
} from "@/apis/api";
import particular from "@/components/common/particular";
import { Utils, Dates } from "@/apis/mUtils";
export default {
  components: {
    particular
  },
  data() {
    return {
      sendStatuss: ["待发送", "已发送", "已撤销"],
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        value1: "",
        value2: "",
        sendStatus: ""
      },
      //具体列表
      users: [],
      listLoading: false, //刷新
      FormVisible: false,
      uid: ""
    };
  },

  methods: {
    //撤销
    Cancel(index, row, item) {
      this.$confirm("确认提交吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let para = {
          id: row.id,
          sendStatus: item
        };
        communicationMessageupdateSendStatus(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(res.data.msg);
            return false;
          }
          this.fetchData();
          this.$message.success("成功");
        });
      });
    },

    //用户
    Details(index, row) {
      this.uid = row.toIdentifier;
      this.FormVisible = true;
    },

    //子隐藏
    show() {
      this.FormVisible = false;
    },
    //关闭弹窗时候触发
    close() {
      this.$refs.userin.Userlist();
      this.fetchData();
    },
    handleEdit(index, row) {
      // console.log(row);
    },
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData();
      console.log(`当前页: ${val}`);
    },

    // 获取用户列表：
    fetchData() {
      this.listLoading = true;
      let para = {
        sendStatus: this.filters.sendStatus,
        pageNo: this.currentPage,
        pageSize: 10, //每页个数
        startTime: this.filters.value1,
        endTime: this.filters.value2
      };
      communicationMessagepage(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取失败`);
            return false;
          }
          console.log(res.data.data.data);
          this.users = res.data.data.data;
          this.total = res.data.data.count;
          this.listLoading = false;
        })
        .catch(() => {
          this.$message.error("请求错误");
          this.listLoading = false;
        });
    },
    getU() {
      this.currentPage = 1;
      this.fetchData();
    },

    chexiao() {
      this.$message.success(`执行撤销`);
    }
  },

  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.formatDate(
      Date.now() - 8.64e7 * 6,
      "yyyy-MM-dd 00:00:00"
    );
    this.filters.value2 = Dates.formatDate(Date.now(), "yyyy-MM-dd 23:59:59");
    this.fetchData();
  }
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;
  text-align: center;
}
.toolbar {
  // margin-bottom: 50px;
}
.list {
  margin-bottom: 50px;
}
</style>