<template>
  <div class="peizhi">
    <el-form ref="addForm" :model="addForm" label-width="130px" :rules="addFormRules">
      <el-form-item label="封面地址：" prop="picUrl">
        <div class="cover">
          <el-input v-model="addForm.picUrl" style="width: 40%;"></el-input>
          <span>或</span>
          <el-upload class="upload" action="/admin/startPage/upload" accept="image/*" list-type="picture-card" :on-error="errUpload" :on-success="handlePictureCardPreview" :on-progress="proUpload" :file-list="fileList" :limit="1">
            <el-button size="small">上传图片</el-button>
          </el-upload>
          <span v-text="text1" style=" color:red;"></span>
        </div>
      </el-form-item>
      <div class="img-box">
        <div class="cover1">
          <span>封面阅览：</span>
          <img :src="addForm.picUrl" alt="" class="img1">
        </div>
      </div>

      <el-form-item label="主标题：" prop="title">
        <el-input v-model="addForm.title" style="width: 220px;" placeholder="单行输入"></el-input>
      </el-form-item>

      <el-form-item label="副标题：" prop="subheading">
        <el-input v-model="addForm.subheading" style="width: 220px;" placeholder="单行输入"></el-input>
      </el-form-item>

      <el-form-item label="主标题字体颜色：" prop="titleColor">
        <el-input v-model="addForm.titleColor" style="width: 220px;" placeholder="RGB值，输入数字"></el-input>
      </el-form-item>

      <el-form-item label="副标题字体颜色：" prop="subheadColor">
        <el-input v-model="addForm.subheadColor" style="width: 220px;" placeholder="RGB值，输入数字"></el-input>
      </el-form-item>

      <el-form-item label="跳转类型：">
        <el-select v-model="addForm.direction" placeholder="选择跳转类型" style="width: 220px;" @change="linkUrl">
          <el-option label="会员+" :value="`VIP+`">
          </el-option>
          <el-option label="充值书币" :value="`BOOK_MONEY_RECHARGE`">
          </el-option>
          <el-option label="消息中心" :value="`MSG_CENTER`">
          </el-option>
          <el-option label="帮助反馈" :value="`HELP_FEEDBACK`">
          </el-option>
          <el-option label="绑定手机" :value="`BIND_PHONE`">
          </el-option>
          <el-option label="设置" :value="`SET_UP`">
          </el-option>
          <el-option label="阅读足迹" :value="`READING_FOOTPRINT`">
          </el-option>
          <el-option label="跳转邀请码" :value="`WRITE_INVITATION_CODE`">
          </el-option>
          <el-option label="H5" :value="``">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="跳转地址：" v-if="addForm.direction == ``" prop="directionPath">
        <div class="cover">
          <el-input v-model="addForm.directionPath" placeholder="跳转地址" style="width: 40%;">
          </el-input>
        </div>
      </el-form-item>
      
      <el-form-item label="排序：" prop="sort">
        <el-input v-model="addForm.sort" style="width: 220px;" placeholder="单行输入"></el-input>
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
import { personalCenterupdate, personalCenterinsert } from "@/apis/api";
export default {
  data() {
    return {
      fileList: [],
      text1: "",
      addForm: {
        direction: "VIP+",
        directionPath: "",
        picUrl: "",
        sort: 0,
        status: 1,
        subheadColor: "",
        subheading: "",
        title: "",
        titleColor: ""
      },
      addFormRules: {
        picUrl: [{ required: true, message: "请填写内容", trigger: "change" }],
        title: [{ required: true, message: "请填写内容", trigger: "blur" }],
        directionPath: [
          { required: true, message: "请填写内容", trigger: "change" }
        ]
      }
    };
  },
  props: ["poplist", "add"],
  methods: {
    linkUrl() {
      this.addForm.directionPath = "";
    },
    onSubmit() {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          this.$confirm("确认提交吗?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          }).then(() => {
            if (this.add == 0) {
              let para = {
                id: this.addForm.id,
                direction: this.addForm.direction,
                directionPath: this.addForm.directionPath,
                picUrl: this.addForm.picUrl,
                sort: this.addForm.sort,
                status: this.addForm.status,
                subheadColor: this.addForm.subheadColor,
                subheading: this.addForm.subheading,
                title: this.addForm.title,
                titleColor: this.addForm.titleColor
              };
              personalCenterupdate(para).then(res => {
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
                direction: this.addForm.direction,
                directionPath: this.addForm.directionPath,
                picUrl: this.addForm.picUrl,
                sort: this.addForm.sort,
                status: this.addForm.status,
                subheadColor: this.addForm.subheadColor,
                subheading: this.addForm.subheading,
                title: this.addForm.title,
                titleColor: this.addForm.titleColor
              };
              personalCenterinsert(pare).then(res => {
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
    },

    go(addForm) {
      this.$emit("hiden");
      this.$refs.addForm.resetFields();
    },

    // 上传时
    proUpload(response, file, fileList) {
      this.text1 = `${Math.ceil(file.percentage)}%`;
    },

    //上传成功
    handlePictureCardPreview(response, file, fileList) {
      this.fileList = [];
      if (response.result !== "success") {
        this.$message.error(response.msg);
        this.text1 = "上传失败";
        return false;
      }
      this.addForm.picUrl = response.msg;
      this.text1 = "上传成功";
    },

    //上传失败
    errUpload() {
      this.fileList = [];
      this.text1 = "上传失败";
    }
  },

  watch: {
    poplist(e) {
      this.text1 = "";
      this.addForm = e;
    }
  },

  mounted() {
    this.text1 = "";
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

.login-btn {
  text-align: center;
}
.login-btn button {
  width: 120px;
  height: 36px;
  margin: 0 30px;
}

.cover {
  display: flex;
  .upload {
    margin-right: 20px;
  }
  span {
    padding: 0 10px;
  }
}

.img-box {
  margin-left: 40px;
  margin-bottom: 20px;

  .cover1 {
    display: flex;
    padding: 10px;
    img {
      width: 60px;
      height: 60px;
      border: 1px solid #ccc;
    }
  }
  .cover2 {
    margin: 0 40px;
    display: flex;
    flex-direction: column;
    img {
      width: 300px;
      height: 100px;
      border: 1px solid #ccc;
    }
    span {
      padding: 0 0 10px 0;
    }
  }
}
.demo {
  display: inline-block;
  width: 70px;
  padding-left: 10px;
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
.data {
  display: flex;
}
</style>
