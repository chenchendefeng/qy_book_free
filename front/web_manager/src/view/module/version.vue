<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" align="center">
      <el-table-column prop="createDate" label="时间" min-width="100" align="center">
      </el-table-column>
      <el-table-column prop="clientType" label="客户端类型" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="version" label="当前版本" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="miniVersion" label="强制更新最小版本" min-width="100" align="center">
      </el-table-column>
      <el-table-column prop="audit" label="是否通过审核" min-width="80" align="center">
        <template slot-scope="scope">
          {{audits[scope.row.audit]}}
        </template>
      </el-table-column>
      <el-table-column prop="des" label="描述" min-width="80" align="center" :show-overflow-tooltip="true">
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="120">
        <template slot-scope="scope">
          <el-button size="small" plain @click="handleEdit(scope.$index, scope.row)">更新</el-button>

          <el-button size="small" plain @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--新增界面-->
    <el-dialog title="增加版本信息" :visible.sync="addFormVisible" width="60%">
      <el-form ref="addForm" :model="addForm" label-width="100px" :rules="addFormRules">
        <el-form-item label="客户端类型" style="width: 40%;" prop="clientType">
          <el-radio-group v-model="addForm.clientType">
            <el-radio label="IOS">IOS</el-radio>
            <el-radio label="Android">Android</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="最新版本号" prop="version">
          <el-input v-model="addForm.version"></el-input>
        </el-form-item>
        <el-form-item label="强制更新最小版本" prop="miniVersion">
          <el-input v-model="addForm.miniVersion"></el-input>
        </el-form-item>
        <el-form-item label="版本下载地址" prop="miniVersion">
          <el-input v-model="addForm.downloadUrl"></el-input>
        </el-form-item>
        <el-form-item label="更新描述" prop="des">
          <el-input type="textarea" :autosize="{ minRows: 5, maxRows: 5}" placeholder="请输入内容" v-model="addForm.des">
          </el-input>
        </el-form-item>
        <el-form-item label="审核状态" prop="audit">
          <el-radio-group v-model="addForm.audit">
            <el-radio :label="1">已通过</el-radio>
            <el-radio :label="0">未通过</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="addSubmit">提交</el-button>
        <el-button @click="addFormVisible = false">取 消</el-button>
      </span>
    </el-dialog>

    <!--修改界面-->
    <el-dialog title="更新版本信息" :visible.sync="EditFormVisible" width="60%">
      <el-form ref="EditForm" :model="EditForm" label-width="100px" :rules="EditFormRules">
        <el-form-item label="客户端类型" style="width: 40%;" prop="clientType">
          <el-radio-group v-model="EditForm.clientType">
            <el-radio label="IOS">IOS</el-radio>
            <el-radio label="Android">Android</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="最新版本号" prop="version">
          <el-input v-model="EditForm.version"></el-input>
        </el-form-item>

        <el-form-item label="强制更新最小版本" prop="miniVersion">
          <el-input v-model="EditForm.miniVersion"></el-input>
        </el-form-item>
        <el-form-item label="版本下载地址" prop="miniVersion">
          <el-input v-model="EditForm.downloadUrl"></el-input>
        </el-form-item>
        <el-form-item label="更新描述" prop="des">
          <el-input type="textarea" :autosize="{ minRows: 5, maxRows: 5}" placeholder="请输入内容" v-model="EditForm.des">
          </el-input>
        </el-form-item>
        <el-form-item label="审核状态" prop="audit">
          <el-radio-group v-model="EditForm.audit">
            <el-radio :label="1">已通过</el-radio>
            <el-radio :label="0">未通过</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="EditSubmit">提交</el-button>
        <el-button @click="EditFormVisible = false">取 消</el-button>
      </span>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import {
  verpage,
  versiondelete,
  versioninsert,
  versionupdate
} from "@/apis/api";
import { Utils } from "@/apis/mUtils";

export default {
  data() {
    return {
      // 分页
      audits: ["未审核", "已审核"],
      clientTypes: ["IOS", "Android"],
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数

      //具体列表
      users: [],
      listLoading: false, //刷新
      role: [],
      // 新增界面
      addFormVisible: false,
      //新增界面数据
      addForm: {
        enable: 1,
        downloadUrl:"",
        clientType: "IOS",
        audit: 0,
        version: "",
        miniVersion: "",
        des: ""
      },
      addFormRules: {
        clientType: [{ required: true, message: "请输选择", trigger: "blur" }],
        audit: [{ required: true, message: "请输选择", trigger: "blur" }],
        version: [{ required: true, message: "请输入版本号", trigger: "blur" }]
      },

      // 修改界面
      EditFormVisible: false,
      EditForm: {},
      EditFormRules: {
        clientType: [{ required: true, message: "请输选择", trigger: "blur" }],
        audit: [{ required: true, message: "请输选择", trigger: "blur" }],
        version: [{ required: true, message: "请输选择", trigger: "blur" }]
      }
    };
  },
  methods: {
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getUsers();
      console.log(`当前页: ${val}`);
    },

    //更新
    handleEdit(index, row) {
      this.EditFormVisible = true;
      this.EditForm = {
        des: row.des,
        clientType: row.clientType,
        audit: row.audit,
        miniVersion: row.miniVersion,
        version: row.version,
        id: row.id,
        downloadUrl:row.downloadUrl
      };
      // console.log(this.EditForm);
    },
    EditSubmit() {
      this.$refs.EditForm.validate(valid => {
        if (valid) {
          let para = this.EditForm;
          console.log(para);
          versionupdate(para).then(res => {
            if (res.data.result !== "success") {
              this.$message.error(res.data.msg);
              return false;
            }
            this.EditFormVisible = false;
            this.$message.success(res.data.msg);
            this.getUsers();
          });
        }
      });
    },

    // 显示新增页面
    handleAdd() {
      this.addForm = {
        enable: 1,
        clientType: "IOS",
        audit: 0,
        version: "",
        miniVersion: "",
        des: "",
        downloadUrl:""
      };
      this.addFormVisible = true;
    },

    //新增数据到用户
    addSubmit() {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          let para = this.addForm;
          console.log(para);
          versioninsert(para).then(res => {
            if (res.data.result !== "success") {
              this.$message.error(res.data.msg);
              return false;
            }
            this.addFormVisible = false;
            this.$message.success(res.data.msg);
            this.getUsers();
          });
        }
      });
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
        versiondelete(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取数据失败`);
            return false;
          }
          this.$message.success(res.data.msg);
          this.getUsers();
        });
      });
    },

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        pageSize: 10,
        pageNo: this.currentPage
      };
      verpage(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
        this.users = data.data;
        this.total = data.count;
        this.listLoading = false;
      });
    }
  },

  // 获取用户数据
  mounted() {
    this.getUsers();
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