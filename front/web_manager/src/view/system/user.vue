<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">

        <el-form-item>
          <el-input v-model="filters.name" placeholder="姓名" prefix-icon="el-icon-search"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getUsers">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;">
      <el-table-column label="排序" type="index" width="50" align="center">
      </el-table-column>
      <el-table-column prop="loginName" label="用户名" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="userName" label="员工名字" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="roles[0].roleName" label="账号类型" min-width="60" align="center">
      </el-table-column>
      <el-table-column prop="dateUpdate" label="创建时间" min-width="70" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="lastLoginTime" label="最近登陆时间" min-width="70" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="lastLoginIp" label="最近登陆IP" min-width="70" align="center" :show-overflow-tooltip="true">
      </el-table-column>

      <el-table-column label="操作" align="center" min-width=200>
        <template slot-scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">修改</el-button>
          <el-button size="small" @click="handleSettings(scope.$index, scope.row)">修改密码</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--编辑界面-->
    <el-dialog title="详细信息" :visible.sync="editFormVisible"  width="400px" v-loading="editLoading">
      <el-form ref="editForm" :model="editForm" label-width="100px" :rules="editFormRules" class="editform">
        <el-form-item label="账户名称" prop="loginName">
          <el-input v-model="editForm.loginName" style="width: 35%;" disabled></el-input>
        </el-form-item>
        <el-form-item label="员工姓名" prop="userName">
          <el-input v-model="editForm.userName" style="width: 35%;"></el-input>
        </el-form-item>
        <el-form-item label="账户角色" prop="rids">
          <el-select v-model="editForm.rids" placeholder="选择角色">
            <el-option :label="item.roleName" :value="item.id" v-for="item in role" :key=item.id>
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveEdit">修改</el-button>
      </span>
    </el-dialog>

    <!--新增界面-->
    <el-dialog title="新增用户" :visible.sync="addFormVisible" width="400px">
      <el-form ref="addForm" :model="addForm" label-width="100px" :rules="addFormRules">
        <el-form-item label="名字" prop="nickname">
          <el-input v-model="addForm.nickname"></el-input>
        </el-form-item>
        <el-form-item label="账号" prop="username">
          <el-input v-model="addForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="addForm.password" type="password"></el-input>
        </el-form-item>
        <el-form-item label="账户角色" prop="rids">
          <el-select v-model="addForm.rids" placeholder="选择角色">
            <el-option :label="item.roleName" :value="item.id" v-for="item in role" :key=item.id>
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="确认密码" prop="password_confirm">
          <el-input v-model="addForm.password_confirm" type="password"></el-input>
        </el-form-item> -->

      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addSubmit">提交</el-button>
      </span>
    </el-dialog>

    <!--权限界面-->
    <el-dialog title="密码修改" :visible.sync="qxFormVisible" width="400px">
      <el-form ref="qxForm" :model="qxForm" label-width="100px" :rules="qxFormRules">
        <el-form-item label="修改密码" prop="password">
          <el-input v-model="qxForm.password" type="password" style="width: 200px;"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="qxFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="qxSubmit">提交</el-button>
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
  getUserList,
  getaddUser,
  deleteUsers,
  roleList,
  updateUser,
  updatePassword
} from "@/apis/api";
export default {
  data() {
    const validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再输入密码"));
      } else if (value !== this.addForm.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      tbl: ["管理员", "用户1", "用户2", "用户3"],
      tb2: ["未激活", "正常", "禁用"],
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //用户名
      filters: {
        name: ""
      },
      //具体列表
      users: [],
      ids: -1,
      listLoading: false, //刷新

      //编辑界面
      editFormVisible: false, //编辑界面是否显示
      editLoading: false, //路由刷新
      role: [],
      //表单验证
      editFormRules: {
        rids: [{ required: true, message: "请选择角色", trigger: "blur" }],
        loginName: [{ required: true, message: "请选择类型", trigger: "blur" }],
        userName: [{ required: true, message: "请输入姓名", trigger: "blur" }]
      },
      editForm: {}, //编辑界面数据

      // 新增界面
      addFormVisible: false,
      addLoading: false,

      //新增界面数据
      addForm: {},
      addFormRules: {
        nickname: [{ required: true, message: "请输入名字", trigger: "blur" }],
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password:[{ required: true, message: "请输入密码", trigger: "blur" }],
        rids:[{ required: true, message: "请选择角色", trigger: "blur" }],
      },
      //权限界面
      qxFormVisible: false,
      qxLoading: false,
      qxForm: {
        password: ""
      },
      qxFormRules: {
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
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

    //显示编辑界面
    handleEdit: function(index, row) {
      this.ids = index;
      this.editFormVisible = true;
      //克隆到 editForm
      this.editForm = Object.assign({}, row);
      this.editForm.rids =   this.editForm.roles[0].id
      console.log(this.editForm);
    },

    // 编辑页面提交
    saveEdit() {
      this.$refs.editForm.validate(valid => {
        console.log(this.editForm);
        if (valid) {
          let para = Object.assign({}, this.editForm);
          // delete para.img;
          let paras = {
            loginName: para.loginName,
            userName: para.userName,
            id: para.id,
            rids: para.rids
          };
          updateUser(paras)
            .then(res => {
              if (res.data.result == "success") {
                this.editFormVisible = false;
                this.$message.success("修改成功");
                this.getUsers();
              } else {
                this.$message.success("修改失败");
              }
            })
            .catch(err => {
              this.editFormVisible = false;
              this.$message.success("修改失败");
              console.log("Error", err.message);
            });
        } else {
          this.$message.success("请输填写必选内容");
        }
      });
    },

    // 显示新增页面
    handleAdd() {
      this.addFormVisible = true;
      this.addForm = {
        nickname: "",
        username: "",
        password: "",
        password_confirm: "",
        rids:""
      };
    },

    //新增数据到用户
    addSubmit() {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          let para = {
            loginName: this.addForm.username,
            password: this.addForm.password,
            rids: this.addForm.rids,
            userName: this.addForm.nickname
          };
          // console.log(para);
          getaddUser(para).then(res => {
            console.log(res);
            if (res.data.result == "success") {
              this.addFormVisible = false;
              this.$message.success("添加成功");
              this.getUsers();
            } else {
              this.$message.success("添加失败");
            }
          });
        } else {
          this.$message.success("请输入完整信息");
        }
      });
    },

    //删除
    handleDelete: function(index, row) {
      this.$confirm("确认删除该用户吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let para = row.id;
        deleteUsers(para)
          .then(res => {
            if (res.data.result == "success") {
              this.getUsers();
              this.$message.success("删除成功");
            } else {
              this.$message.success("删除失败");
            }
          })
          .catch(err => {
            console.log("Error", err.message);
          });
      });
    },

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        userName: this.filters.name, //关键字
        pageSize: 10,
        pageNo: this.currentPage
      };
      getUserList(para)
        .then(res => {
          this.listLoading = false;
          // console.log(res.data.data);
          let data = res.data.data;
          this.total = data.count;
          this.users = data.data;
        })
        .catch(() => {
          this.listLoading = false;
          // this.$message.error(`请求错误`);
        });
    },

    //权限设置
    handleSettings(index, row) {
      this.qxForm.id = row.id;
      this.qxForm.password = "";
      this.qxFormVisible = true;
    },
    //权限提交
    qxSubmit() {
      this.$confirm("确认修改密码吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let para = {
          id: this.qxForm.id,
          password: this.qxForm.password
        };
        console.log(para);
        updatePassword(para)
          .then(res => {
            if (res.data.result == "success") {
              this.getUsers();
              this.$message.success("修改成功");
            } else {
              this.$message.success("修改失败");
            }
            this.qxFormVisible = false;
          })
          .catch(err => {
            console.log("Error", err.message);
          });
      });
    },
    currentSel(a) {
      console.log(a);
    }
  },

  // 获取用户数据
  mounted() {
    this.getUsers();
    roleList().then(res => {
        console.log(res.data.data);
        this.role = res.data.data;
      });
    // let a = [1, 2, 3];
    // console.log(a.join(), 111);
  }
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;
  text-align: center;
}
</style>
