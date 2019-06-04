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
      :data="users"
      highlight-current-row
      v-loading="listLoading"
      style="width: 100%;"
      align="center"
      border
    >
      <el-table-column label="排序" type="index" width="50" align="center"></el-table-column>
      <el-table-column prop="fileType" label="类型" min-width="60" align="center">
        <template slot-scope="scope">{{scope.row.fileType == 'video' ? "视频":"图片"}}</template>
      </el-table-column>
      <el-table-column label="封面" min-width="170" align="center">
        <template slot-scope="scope">
          <span style="cursor: pointer;">
            <img
              v-if="scope.row.fileType !== `video`"
              :src="scope.row.fileUrl"
              alt
              @click="preview(scope.row)"
              style="width: 100px;height: 150px; "
              align="center"
            >
            <video
              v-else
              :src="scope.row.fileUrl"
              controls
              controlslist="nodownload"
              @click="preview(scope.row)"
              style="width: 100px;height: 150px; "
            >您的浏览器不支持 video 标签。</video>
          </span>
        </template>
      </el-table-column>

      <el-table-column prop="clientType" label="客户端" min-width="60" align="center"></el-table-column>
      <el-table-column label="状态" min-width="100" align="center">
        <template slot-scope="scope">
          <p>{{statuss[scope.row.status]}}</p>
          <p>{{scope.row.beginDate}}</p>
          <p>{{scope.row.endDate}}</p>
        </template>
      </el-table-column>
      <el-table-column
        prop="channelCodes"
        label="渠道"
        min-width="80"
        align="center"
        :show-overflow-tooltip="true"
      >
        <template slot-scope="scope">{{reversedMessage(scope.row.channelCodes)}}</template>
      </el-table-column>
      <el-table-column label="操作" align="center" min-width="100">
        <template slot-scope="scope">
          <el-button type="text" @click="handleEdit(scope.$index, scope.row)">修改</el-button>

          <el-button type="text" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--新增界面-->
    <el-dialog title="启动页配置" :visible.sync="addFormVisible" width="70%" @closed="close">
      <start :poplist="poplist" @hiden="show" :add="add" ref="sta"></start>
    </el-dialog>

    <!--预览-->
    <el-dialog :visible.sync="previewVisible">
      <div class="preview-box">
        <img
          v-if="this.previewItem.fileType !== `video`"
          :src="this.previewItem.fileUrl"
          alt
          style="width: 320px;height: 568px; "
          align="center"
        >
        <video
          v-else
          :src="this.previewItem.fileUrl"
          controls
          controlslist="nodownload"
          style="width: 450px;height:300px; "
        >您的浏览器不支持 video 标签。</video>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import { startPagelist, startPagedelete } from "@/apis/api";
import { Utils, getStore } from "@/apis/mUtils";
import start from "@/components/module/start";
export default {
  components: {
    start
  },
  data() {
    return {
      statuss: ["停用", "启用"],
      systemTypes: ["全部", "安卓", "ios"],
      // imgtype: 1,
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //用户名
      filters: {
        status: 1,
        channel: ""
      },
      //具体列表
      users: [],
      listLoading: false, //刷新
      role: JSON.parse(getStore("role") || "[]"),
      // 新增界面
      addFormVisible: false,
      previewVisible: false,
      previewItem: {},
      addLoading: false,
      textarea3: "",
      //新增界面数据
      addForm: {},
      addFormRules: {
        roleName: [{ required: true, message: "请输入姓名", trigger: "blur" }]
      },
      poplist: "",
      add: 0
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
    preview(item) {
      this.previewVisible = true;
      this.previewItem = item;
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
        fileType: "pic",
        fileUrl: "",
        beginDate: "",
        endDate: "",
        status: 1,
        channelCodes: "",
        clientType: "all"
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
        let para = {
          id: row.id
        };
        startPagedelete(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`删除失败`);
            return false;
          }
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
      startPagelist(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data;
        console.log(data.data);
        this.users = data.data;
        // this.total = data.count;
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
    // if (this.users.fileType == "video") {
    //   this.imgtype = 0;
    // } else {
    //   this.imgtype = 1;
    // }
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
  cursor: pointer;
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
video::-webkit-media-controls-fullscreen-button {
  display: none;
}
.preview-box {
  text-align: center;
}
</style>