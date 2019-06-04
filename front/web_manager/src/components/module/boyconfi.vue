<template>
  <div class="peizhi">
    <el-form ref="addForm" :model="addForm" label-width="120px" :rules="addFormRules">

      <el-form-item label="分类标题：" prop="title">
        <el-input v-model="addForm.title" style="width: 220px;" placeholder="单行输入"></el-input>
      </el-form-item>

      <el-form-item label="标题字体颜色：" prop="fontColor">
        <el-input v-model="addForm.fontColor" style="width: 220px;" placeholder="单行输入"></el-input>
      </el-form-item>

      <el-form-item label="标题排序：" prop="sort">
        <el-input v-model="addForm.sort " style="width: 220px;" placeholder="单行输入"></el-input>
      </el-form-item>

      <el-form-item label="子类ID：">
        <el-input v-model="current" style="width: 220px;" placeholder="单行输入"></el-input>
        <!-- :disabled="aa" -->
        <el-button @click="push(current)">添加</el-button>
      </el-form-item>

      <el-form-item label="状态：">
        <el-select v-model="addForm.status" placeholder="有效" style="width: 220px;">
          <el-option label="有效" :value="1">
          </el-option>
          <el-option label="无效" :value="0">
          </el-option>
        </el-select>
      </el-form-item>
    </el-form>

    <p>&nbsp;已添加分类名称：</p>
    <div class="zilei">
      <ul>
        <li v-for="(item,index) in addForm.subcategoryDtoList" :key=index>
          <span>{{item.subcategoryname}}</span>
          <el-button type="info" @click="remove(index)" icon="el-icon-close" circle plain></el-button>
        </li>
      </ul>
    </div>

    <div class="foot">
      <div class="login-btn">
        <el-button type="danger" @click="onSubmit">确定</el-button>
      </div>
      <div class="login-btn">
        <el-button type="info" @click="go">取消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import {
  categorygetDtoBySubcategoryId,
  thememoduleupdate,
  thememoduleinsert
} from "@/apis/api";
export default {
  data() {
    return {
      addForm: {
        fontColor: "",
        sort: 0,
        status: 1,
        subcategoryidList: [],
        subcategoryDtoList: [],
        themeId: "",
        title: ""
      },
      addFormRules: {
        title: [{ required: true, message: "请填写", trigger: "blur" }],
        sort: [{ required: true, message: "请填写", trigger: "blur" }]
      },
      //添加
      current: ""
    };
  },
  props: ["poplist", "add"],
  methods: {
    onSubmit() {
      console.log(this.addForm.subcategoryDtoList)
      if (this.addForm.subcategoryDtoList.length) {
        this.$refs.addForm.validate(valid => {
          if (valid) {
            this.$confirm("确认提交吗?", "提示", {
              confirmButtonText: "确定",
              cancelButtonText: "取消",
              type: "warning"
            }).then(() => {
              if (this.add == 0) {
                let para = {
                  subcategoryidList: this.addForm.subcategoryidList,
                  id: this.addForm.id,
                  themeId: this.addForm.themeId,
                  title: this.addForm.title,
                  fontColor: this.addForm.fontColor,
                  status: this.addForm.status,
                  sort: this.addForm.sort
                };
                thememoduleupdate(para).then(res => {
                  console.log(res);
                  if (res.data.result !== "success") {
                    this.$message.error(res.data.msg);
                    return false;
                  }
                  this.$message.success("修改成功");
                });
                this.$emit("hiden");
              } else {
                let pare = {
                  subcategoryidList: this.addForm.subcategoryidList,
                  themeId: this.addForm.themeId,
                  title: this.addForm.title,
                  fontColor: this.addForm.fontColor,
                  status: this.addForm.status,
                  sort: this.addForm.sort
                };
                thememoduleinsert(pare).then(res => {
                  console.log(res);
                  if (res.data.result !== "success") {
                    this.$message.error(res.data.msg);
                    return false;
                  }
                  this.$message.success("添加成功");
                });
                this.$emit("hiden");
              }
            });
          } else {
            console.log(this.addForm);
            this.$message.warning("请输入完整信息");
          }
        });
      } else {
        console.log(this.addForm);
        this.$message.warning("请添加分类");
      }
    },

    go(addForm) {
      this.$confirm("确认取消吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(res => {
        this.$emit("hiden");
        this.$refs.addForm.resetFields();
      });
    },

    go1(addForm) {
      this.$emit("hiden");
      this.$refs.addForm.resetFields();
    },

    //添加
    push(val) {
      if (!val) {
        this.$message.error("不能输入为空");
      } else {
        let para = {
          subcategoryid: val
        };
        categorygetDtoBySubcategoryId(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error("请输入正确ID");
            return false;
          }

          let flag = false;
          this.addForm.subcategoryDtoList.some(item => {
            if (item.subcategoryid == res.data.data.subcategoryid) {
              this.$message.error("不能添加重复");
              flag = true;
              return true;
            }
          });
          if (!flag) {
            this.addForm.subcategoryDtoList.push(res.data.data);
            this.addForm.subcategoryidList.push(res.data.data.subcategoryid);
          }
          console.log(this.addForm);
        });
      }
    },

    //点击删除，删除对应的数据信息：
    remove(k) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(res => {
        this.addForm.subcategoryDtoList.splice(k, 1);
        this.addForm.subcategoryidList.splice(k, 1);
      });
    }
  },
  watch: {
    poplist(e) {
      this.current = "";
      this.addForm = e;
    }
  },

  mounted() {
    this.current = "";

    this.addForm = this.poplist;
  }
};
</script>


<style lang="less" scoped>
.foot {
  display: flex;
  height: 100px;
  justify-content: center;
  align-items: center;
}

.img-box {
  margin-bottom: 10px;
  display: flex;
  .cover1 {
    display: flex;
    .vide-img {
      border: 1px solid #ccc;
      width: 140px;
      height: 140px;
    }
    span {
      padding: 0 10px 0 0;
    }
  }
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 120px;
  height: 36px;
  margin: 0 30px;
}

.zilei {
  margin: 40px 0 10px 10px;
  padding: 10px 20px;

  ul,
  li {
    padding: 0;
    margin: 0;
    list-style: none;
  }
  ul {
    overflow: auto;
    max-height: 290px;
    min-height: 80px;
    padding: 10px;
    // border: 1px solid #c4c4c4;
    width: 100%;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    align-items: flex-start;
    li {
      width: 230px;
      height: 50px;
      line-height: 50px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      span {
        width: 170px;
        display: inline-block;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
      button {
        margin-right: 15px;
      }
    }
  }
}
</style>
