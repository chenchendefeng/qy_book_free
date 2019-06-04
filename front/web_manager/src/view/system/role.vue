<template>
  <section>
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <!-- <el-form-item>
					<el-input v-model="filters.name" placeholder="姓名" prefix-icon="el-icon-search"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary"  @click="getUsers">查询</el-button>
				</el-form-item> -->
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;">

      <el-table-column prop="id" label="ID" min-width="120" align="center">
      </el-table-column>
      <el-table-column prop="roleName" label="名字" min-width="150" align="center">
      </el-table-column>
      <el-table-column label="操作" min-width="200" align="center">
        <template slot-scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">修改</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--编辑界面-->
    <el-dialog title="权限详情" :visible.sync="editFormVisible" v-loading="editLoading" width="800px">
      <el-tree :data="permissionLi" show-checkbox default-expand-all node-key="id" ref="tree" highlight-current :default-checked-keys="[5]" :props="defaultProps">
      </el-tree>

      <span slot="footer" class="dialog-footer">
        <el-button @click="editFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveEdit">修改</el-button>
      </span>
    </el-dialog>

    <!--新增界面-->
    <el-dialog title="新增角色" :visible.sync="addFormVisible" width="30%">
      <el-form ref="addForm" :model="addForm" label-width="100px" :rules="addFormRules">
        <el-form-item label="名字" prop="roleName">
          <el-input v-model="addForm.roleName"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addSubmit">提交</el-button>
      </span>
    </el-dialog>

    <!-- 分页 -->
    <!-- <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="10" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div> -->

  </section>
</template>

<script>
import {
  deleteUsers,
  roleList,
  updateUser,
  addRole,
  deleteRole,
  permissionList,
  roleDetail,
  updateRole
} from "@/apis/api";
import { Utils } from "@/apis/mUtils";

export default {
  data() {
    return {
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
        roleName: [{ required: true, message: "请输入姓名", trigger: "blur" }]
      },
      role: [],
      permissionLi: [],
      defaultProps: {
        children: "kids",
        label: "rightName"
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
      this.editFormVisible = true;
      roleDetail(row.id)
        .then(res => {
          let para = res.data.data.permissions;
          let permissions = [];
          para.forEach(function(item) {
            if (item.parentId !== 0) {
              permissions.push(item);
            }
          });
          // console.log(permissions)
          this.role = permissions;
        })
        .catch(err => {
          console.log("Error", err.message);
        });
      // 克隆到 editForm
      this.editForm = Object.assign({}, row);
      console.log(this.editForm);
      setTimeout(() => {
        this.$refs.tree.setCheckedNodes(this.role);
      }, 500);
    },

    // 编辑页面提交
    saveEdit() {
      let pid = [];
      this.$refs.tree.getCheckedNodes(false, true).forEach(item => {
        pid.push(item.id);
      });
      let para = {
        roleName: this.editForm.roleName,
        id: this.editForm.id,
        pids: pid.join(",")
      };
      // console.log(pid.join(","))
      // console.log(this.$refs.tree.getCheckedNodes(false, true))
      updateRole(para)
        .then(res => {
          if (res.data.result == "success") {
            this.getUsers();
            this.$message.success("修改权限成功");
            return;
          } else {
            this.$message.err("修改失败");
          }
        })
        .catch(err => {
          this.$message.err("修改失败");
          console.log("Error", err.message);
        });
      this.editFormVisible = false;
    },

    // 显示新增页面
    handleAdd() {
      this.addFormVisible = true;
      this.addForm = {
        roleName: ""
      };
    },

    //新增数据到用户
    addSubmit() {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          let para = {
            roleName: this.addForm.roleName
          };
          console.log(para);
          addRole(para)
            .then(res => {
              console.log(res);
              if (res.data.result == "success") {
                this.addFormVisible = false;
                this.$message.success("添加成功");
                this.getUsers();
              } else {
                this.$message.success("添加失败");
              }
            })
            .catch(err => {
              this.loadingFlag = false;
              console.log("Error", err.message);
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
        deleteRole(para)
          .then(res => {
            if (res.data.result == "success") {
              this.getUsers();
              this.$message.success("删除成功");
            } else {
              this.$message.success("删除失败");
            }
          })
          .catch(err => {
            this.loadingFlag = false;
            console.log("Error", err.message);
          });
      });
    },

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      // this.users = [{ id: 1 }];
      roleList()
        .then(res => {
          this.listLoading = false;
          if (res.data.result == "success") {
            this.users = res.data.data;
            return;
          } else {
            this.$message.success("请求错误");
          }
        })
        .catch(err => {
          this.listLoading = false;
          // this.$message.error(`请求错误`);
          console.log("Error", err.message);
        });
    },

    permiss() {
      permissionList()
        .then(res => {
          if (res.data.result == "success") {
            this.permissionLi = res.data.data;
            console.log(this.permissionLi);
            return;
          } else {
            // this.$message.error("修改失败");
          }
        })
        .catch(err => {
          console.log("Error", err.message);
        });
    }
  },

  // 获取用户数据
  mounted() {
    this.getUsers();
    this.permiss();
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
</style>