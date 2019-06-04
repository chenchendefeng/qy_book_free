<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="filters.status">
            <el-radio :label="1">有效</el-radio>
            <el-radio :label="0">无效</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="渠道" prop="channel">
          <el-select v-model="filters.channel" placeholder="全部" style="width: 90px;">
            <el-option :label="item.name" :value="item.channle" v-for="item of role" :key="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getUse">查找</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="Reset">重置</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table
      :data="list"
      highlight-current-row
      v-loading="listLoading"
      style="width: 100%;"
      align="center"
      border
    >
      <el-table-column label="排序" prop="orderNo" width="50" align="center"></el-table-column>
      <el-table-column prop="question" label="问题" width="150" align="center"></el-table-column>
      <el-table-column prop="answer" label="答案" width="300" align="center"></el-table-column>
      <el-table-column prop="channle" label="渠道" min-width="100" align="center">
        <template slot-scope="scope">{{reversedMessage(scope.row.channle)}}</template>
      </el-table-column>
      <el-table-column prop="status" label="状态" min-width="60" align="center">
        <template slot-scope="scope">{{statuss[scope.row.status]}}</template>
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="100">
        <template slot-scope="scope">
          <el-button type="text" @click="handleEdit(scope.$index, scope.row)">修改</el-button>

          <el-button type="text" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--新增界面-->
    <el-dialog title="配置" :visible.sync="addFormVisible" width="900px" @closed="close">
      <helps :poplist="poplist" :add="add" @hiden="show" ref="tan"></helps>
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
import { helppage, helpdelete } from "@/apis/api";
import { getStore } from "@/apis/mUtils";
import helps from "@/components/module/helps";
export default {
  components: {
    helps
  },
  data() {
    return {
      statuss: ["停用", "启用"],
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //用户名
      //用户名
      filters: {
        status: 1,
        channel: ""
      },
      role: JSON.parse(getStore("role") || "[]"),
      //具体列表
      list: [],
      listLoading: false, //刷新
      // 新增界面
      poplist: "",
      add: 0,
      addFormVisible: false
    };
  },
  methods: {
    close() {
      this.$refs.tan.go("addForm");
      this.fetchData();
    },
    show() {
      this.addFormVisible = false;
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

    //重置
    Reset() {
      this.filters.channel = "";
      this.filters.status = 1;
    },

    //修改
    handleEdit(index, row) {
      this.add = 0;
      if (row.channle == -1) {
        this.poplist = {
          id: row.id,
          answer: row.answer,
          channle: "",
          orderNo: row.orderNo,
          question: row.question,
          status: row.status
        };
      } else {
        this.poplist = {
          id: row.id,
          answer: row.answer,
          channle: row.channle,
          orderNo: row.orderNo,
          question: row.question,
          status: row.status
        };
      }
      this.addFormVisible = true;
    },

    // 显示新增页面
    handleAdd() {
      this.add = 1;
      this.poplist = {
        answer: "",
        channle: "",
        orderNo: this.total,
        question: "",
        status: 1
      };
      this.addFormVisible = true;
    },

    //删除
    handleDelete(index, row) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let para = {
          id: row.id
        };
        helpdelete(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`删除失败`);
            return false;
          }
          this.fetchData();
          this.$message.success("删除成功");
        });
      });
    },

    // 获取用户列表：
    fetchData() {
      this.listLoading = true;
      let para = {
        channle: this.filters.channel,
        status: this.filters.status,
        pageSize: 10,
        pageNo: this.currentPage
      };
      helppage(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
        console.log(data.data);
        this.list = data.data;
        this.total = data.count;
        this.listLoading = false;
      });
    },

    getUse() {
      this.currentPage = 1;
      this.fetchData();
    },
    reversedMessage(value) {
      if (value == -1) return "全部";
      if (!value) return "全部";
      let c = value.split(",");
      let d = "";
      c.forEach(item => {
        this.role.forEach(val => {
          if (val.channle == item) {
            d += val.name + "  ";
          }
        });
      });
      return d;
    }
  },

  // 获取用户数据
  mounted() {
    this.fetchData();
  }
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;
  margin-bottom: 50px;
  text-align: center;
}

.opera {
  height: 100%;
}
.tite {
  text-align: center;
}
.checkboxs {
  display: flex;
  flex-direction: column-reverse;
  justify-content: center;
}
.el-checkbox + .el-checkbox {
  margin: 0;
  height: 30px;
}

.el-tree {
  width: 100%;
  display: flex;
  justify-content: space-around;

  div {
    flex: 1;
  }
}
.dialog-footer {
  display: flex;
  justify-content: center;
}
</style>