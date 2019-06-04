<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item label="状态：">
          <el-select v-model="filters.status" placeholder="状态" style="width: 90px;">
            <el-option label="全部" value="" />
            <el-option label="上架" :value="1" />
            <el-option label="下架" :value="0" />
          </el-select>
        </el-form-item>
        <el-form-item label="渠道：" prop="channel">
          <el-select v-model="filters.channel" placeholder="全部" style="width: 90px;">
            <el-option :label="item.name" :value="item.channle" v-for="item of role" :key=item.id>
            </el-option>
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
    <el-table :data="list" highlight-current-row v-loading="listLoading" style="width: 100%;" align="center" border>

      <el-table-column prop="img" label="封面" width="120" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.img" alt="" style="width: 40px;height: 50px; " align="center">
        </template>
      </el-table-column>
      <el-table-column prop="showPage" label="位置" min-width="100" align="center">
        <template slot-scope="scope">
          {{scope.row.showPage || '--'}}
        </template>
      </el-table-column>
      <el-table-column prop="windowType" label="规格" min-width="100" align="center">
        <template slot-scope="scope">
          {{windowTypes[scope.row.windowType] || '--'}}
        </template>
      </el-table-column>
      <el-table-column prop="clientType" label="客户端" min-width="100" align="center">
        <template slot-scope="scope">
          {{(scope.row.clientType == 'all' ? '全部' : scope.row.clientType) || '--'}}
        </template>
      </el-table-column>
      <el-table-column prop="status" label="状态" min-width="100" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <p>{{statuss[scope.row.status]}}</p>
          <p>{{scope.row.showStartDate}}</p>
          <p>{{scope.row.showEndDate}}</p>
        </template>
      </el-table-column>
      <el-table-column prop="channel" label="渠道" min-width="80" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          {{reversedMessage(scope.row.channel) || '--'}}
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="100">
        <template slot-scope="scope">
          <el-button type="text" @click="handleEdit(scope.$index, scope.row)">修改</el-button>
          <el-button type="text" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--新增界面-->
    <el-dialog title="弹窗配置" :visible.sync="addFormVisible" width="50%" @closed="close">
      <popup :poplist="poplist" :add="add" @hiden="show" ref="tan">></popup>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging" v-if="total">
      <el-pagination background @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import {
  popupWindowManagerlist,
  popupWindowadd,
  popupWindelete,
  popactivilist
} from "@/apis/api";
import { getStore } from "@/apis/mUtils";
import popup from "@/components/module/popup";
export default {
  components: {
    popup
  },
  data() {
    return {
      windowTypes: ["大窗", "小窗"],
      showTypes: ["点击消失", "一直显示"],
      statuss: ["下架","上架"],
      currentPage: 1, 
      total: 0, 
      filters: {
        status: 1,
        channel: ""
      },
      list: [],
      listLoading: false, //刷新
      role: JSON.parse(getStore("role") || "[]"),
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
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData();
    },

    //重置
    Reset() {
      this.filters.channel = "";
      this.filters.status = 1;
    },

    //修改
    handleEdit(index, row) {
      this.add = 0;
      this.poplist = row;
      this.addFormVisible = true;
    },

    // 显示新增页面
    handleAdd() {
      this.add = 1;
      this.poplist = {
        showType: 1,
        windowType: 0,
        showPage: "recommend",
        clientType: "all",
        status: 1,
        channel: "",
        showStartDate: "",
        showEndDate: "",
        skipType: 0,
        skipUrl: "recharge",
        img: ""
      };
      this.addFormVisible = true;
    },

    //删除
    handleDelete: function(index, row) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        popupWindelete({
          id: row.id
        }).then(res => {
          this.$message.success("删除成功");
          this.fetchData();
        });
      });
    },

    // 获取用户列表：
    fetchData() {
      this.listLoading = true;
      let para = {
        pageSize: 10,
        pageNo: this.currentPage,
        channel: this.filters.channel,
        status: this.filters.status
      };
      popupWindowManagerlist(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
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