<template>
  <section class="bane">
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
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" align="center" border>
      <el-table-column label="排序" type="index" width="50" align="center">
      </el-table-column>
      <el-table-column prop="img" label="封面" width="240" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.img" alt="" style="width: 160px;height: 80px; " align="center">
        </template>
      </el-table-column>
      <el-table-column prop="position" label="位置" min-width="100" align="center">
         <template slot-scope="scope">
          {{label[scope.row.position]}}
        </template>
      </el-table-column>
      <el-table-column prop="status" label="状态" min-width="100" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <p>{{statuss[scope.row.validStatus]}}</p>
          <p>{{scope.row.beginTime}}</p>
          <p>{{scope.row.endTime}}</p>
        </template>
      </el-table-column>
      <el-table-column prop="channel" label="渠道" min-width="60" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          {{reversedMessage(scope.row.channel)}}
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
    <el-dialog title="配置" :visible.sync="addFormVisible" width="900px" @closed="close">
      <bannerr :poplist="poplist" @hiden="show" :add="add" ref="sta"></bannerr>
    </el-dialog>

    <!-- 分页 -->
    <!-- <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div> -->

  </section>
</template>

<script>
import { bannerlist, bannerdelete } from "@/apis/api";
import { getStore } from "@/apis/mUtils";
import bannerr from "@/components/module/bannerr";
export default {
  components: {
    bannerr
  },
  data() {
    return {
      showPages: { bookStore: "书库", choice: "精选", readerGuiding: "导读" },
      statuss: ["停用", "启用"],
      systemTypes: ["全部", "安卓", "ios"],
      //用户名
      filters: {
        status: 1,
        channel: ""
      },
      //具体列表
      users: [],
      listLoading: false, //刷新
      role: JSON.parse(getStore("role") || "[]"),
      addFormVisible: false,
      poplist: "",
      add: 0,
      label:{
        boy: "男生专区",
        girl: "女生专区",
        recommend: "推荐专区",
        personalCenter: "个人中心",
        categoryBoy: "分类-男生",
        categoryGirl: "分类-女生",
      }
    };
  },
  methods: {
    close() {
      this.$refs.sta.go("addForm");
      this.getUsers();
    },
    show() {
      this.addFormVisible = false;
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
        beginTime: "",
        endTime: "",
        channel: "",
        img: "",
        position: "recommend",
        type: "app",
        validStatus: 1,
        url: ""
      };
      this.addFormVisible = true;
    },


    //删除
    handleDelete: function(index, row) {
      //
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let para = {
          id: row.id
        };
        bannerdelete(para).then(res => {
          // if (res.data.result !== "success") {
          //   this.$message.error(`获取数据失败`);
          //   return false;
          // }
          this.$message.success("删除成功");
          this.getUsers();
        });
      });
    },

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        channelCode: this.filters.channel,
        status: this.filters.status
      };
      bannerlist(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        this.users = res.data.data;
        this.listLoading = false;
      });
    },
    getUse() {
      this.currentPage = 1;
      this.getUsers();
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
    this.getUsers();
  }
};
</script>

<style lang="less" scoped>
.bane {
  margin-bottom: 50px;
}
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