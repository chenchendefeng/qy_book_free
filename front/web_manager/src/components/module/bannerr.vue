<template>
  <div class="peizhi">
    <el-form ref="addForm" :model="addForm" label-width="110px" :rules="addFormRules">
      <el-form-item label="封面地址：" prop="img">
        <div class="cover">
          <el-input
            v-model="addForm.img"
            style="width: 40%;"
            @keyup.enter.native="dialogImageUrl=addForm.img"
            @blur="dialogImageUrl=addForm.img"
          ></el-input>
          <span>或</span>
          <el-upload
            class="upload"
            action="/admin-free/upload/picture"
            accept="image/*"
            list-type="picture-card"
            :on-error="errUpload"
            :on-success="handlePictureCardPreview"
            :on-progress="proUpload"
            :file-list="fileList"
            :limit="1"
          >
            <el-button size="small">上传图片</el-button>
          </el-upload>
          <span v-text="text" style=" color:red;"></span>
        </div>
      </el-form-item>
      <div class="img-box">
        <div class="cover">
          <span>封面阅览：</span>
          <img :src="dialogImageUrl" alt>
        </div>
      </div>
      <el-form-item label="跳转去向：" prop="type">
        <el-select v-model="addForm.type">
          <el-option label="APP内跳转" :value="'app'"/>
          <el-option label="H5跳转" :value="'h5'"/>
        </el-select>
      </el-form-item>
      <el-form-item v-if="addForm.type === 'app'" label="跳转地址：">
        <el-select v-model="addForm.sType" placeholder="选择跳转页面">
          <el-option label="书架页" value="bookshelf"/>
          <el-option label="绑定手机" value="bindPhone"/>
          <el-option label="填红包码" value="rewardCode"/>
          <el-option label="我的钱包" value="wallet"/>
          <el-option label="我要提现" value="withdraw"/>
          <el-option label="邀请好友" value="invite"/>
          <el-option label="签到页" value="checkIn"/>
          <el-option label="福利页" value="welfare"/>
          <el-option label="书籍详情" value="book"/>
          <el-option label="开通会员" value="joinMembership"/>
          <el-option label="播放广告视频" value="video"/>
        </el-select>
        <el-input v-if="addForm.sType ==='book'" v-model.trim="addForm.bookID" placeholder="书籍ID"/>
      </el-form-item>
      <el-form-item v-if="addForm.type === 'h5'" label="跳转地址：">
        <el-input v-model.trim="addForm.link" placeholder="跳转地址"/>
      </el-form-item>
      <el-form-item label="banner位置：">
        <el-select v-model="addForm.position" placeholder="选择跳转位置">
          <el-option label="推荐专区" :value="`recommend`"></el-option>
          <el-option label="男生专区" :value="`boy`"></el-option>
          <el-option label="女生专区" :value="`girl`"></el-option>
          <el-option label="个人中心" :value="`personalCenter`"></el-option>
          <el-option label="分类-男生" :value="`categoryBoy`"></el-option>
          <el-option label="分类-女生" :value="`categoryGirl`"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="开始时间：" prop="beginTime">
        <el-date-picker
          v-model="addForm.beginTime"
          type="datetime"
          placeholder="选择日期时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          :picker-options="pickerOptions0"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间：" prop="endTime">
        <el-date-picker
          v-model="addForm.endTime"
          type="datetime"
          placeholder="选择日期时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          :picker-options="pickerOptions1"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="状态：">
        <el-select v-model="addForm.validStatus" placeholder="有效">
          <el-option label="有效" :value="1"></el-option>
          <el-option label="无效" :value="0"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="渠道：" prop="roleName">
        <el-input v-model="addForm.channel" placeholder="单行输入"></el-input>
        <br>
        <span>渠道为空时，对所有可见，多渠道并存是用,隔开</span>
      </el-form-item>
    </el-form>
    <div class="foot">
      <div class="login-btn">
        <el-button v-if="add" type="danger" @click="onSubmit">确定</el-button>
        <el-button v-else type="danger" @click="onSubmit">确定</el-button>
      </div>
      <div class="login-btn">
        <el-button type="info" @click="go">取消</el-button>
      </div>
    </div>
  </div>
</template>
<script>
import { bannersaveOrUpdate, stOSSFile } from "@/apis/api";
export default {
  data() {
    return {
      addForm: {
        beginTime: "",
        endTime: "",
        channel: "",
        img: "",
        position: "recommend",
        type: "app",
        url: "",
        sType: "",
        link: "",
        validStatus: 1
      },
      fileList: [],
      dialogImageUrl: "",
      text: "",
      addFormRules: {
        img: [{ required: true, message: "请填写图片地址", trigger: "change" }],
        beginTime: [{ required: true, message: "请填写内容", trigger: "blur" }],
        endTime: [{ required: true, message: "请填写内容", trigger: "blur" }]
      },
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() <= Date.now() - 8.64e7;
        }
      },
      pickerOptions1: {
        disabledDate: time => {
          if (this.value1 != "") {
            let moth = new Date(this.addForm.value1).getTime();
            return (
              time.getTime() <= moth - 8.64e7 ||
              time.getTime() <= Date.now() - 8.64e7
            );
          }
        }
      },
      hiden: false
    };
  },
  props: ["poplist", "add"],
  methods: {
    //触发
    skipTypes() {
      this.addForm.url = "";
    },

    onSubmit() {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          this.$confirm("确认提交吗?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          }).then(() => {
            let param = Object.assign({}, this.addForm);
            let skipObj = {};
            if (param.type === "app") {
              let idStr = param.sType === "book" ? "://" + param.bookID : "";
              if (param.sType === "video") {
                Object.assign(skipObj, {
                  linkType: "video"
                });
              } else {
                Object.assign(skipObj, {
                  linkType: "app",
                  url: param.sType + idStr
                });
              }
            } else {
              Object.assign(skipObj, {
                linkType: "h5",
                url: param.link
              });
            }
            param.url = JSON.stringify(skipObj);
            bannersaveOrUpdate(param).then(res => {
              if (res.data.result !== "success") {
                this.$message.error(`添加或修改失败`);
                return false;
              }
              this.$message.success("添加或修改成功");
            });
            this.$emit("hiden");
          });
        } else {
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
      this.text = `${Math.ceil(file.percentage)}%`;
    },
    //上传成功
    handlePictureCardPreview(response, file, fileList) {
      this.fileList = [];
      if (response.result !== "success") {
        this.$message.error(response.msg);
        this.text = "上传失败";
        return false;
      }
      this.addForm.img = response.msg;
      this.dialogImageUrl = response.msg;
      this.text = "上传成功";
    },
    //上传失败
    errUpload() {
      this.fileList = [];
      this.text = "上传失败";
    },
    setSkip() {
      console.log(this.addForm.url)
      let skipObj = Object.assign({}, JSON.parse(this.addForm.url));
      let obj = {},
        url = skipObj.url;
      if (skipObj.linkType === "app") {
        if (/book:/.test(url)) {
          obj.sType = url.split("://")[0];
          obj.bookID = url.split("://")[1];
        } else {
          obj.sType = url;
        }
      } else if (skipObj.linkType === "video") {
        obj.sType = "video";
      } else {
        obj.link = url;
      }
      this.addForm = Object.assign({}, this.addForm, obj);
    }
  },
  watch: {
    poplist(e) {
      this.text = "";
      this.addForm = e;
      this.dialogImageUrl = e.img;
      this.setSkip();
    }
  },
  mounted() {
    this.text = "";
    this.addForm = this.poplist;
    this.dialogImageUrl = this.poplist.img;
    this.setSkip();
  }
};
</script>
<style lang="less" scoped>
.peizhi {
  .el-input,
  .el-select {
    width: 240px;
  }
}
.foot {
  display: flex;
  height: 100px;
  justify-content: center;
  align-items: center;
}
.login-btn {
  text-align: center;
  button {
    width: 120px;
    height: 36px;
    margin: 0 30px;
  }
}
.cover {
  display: flex;
  span {
    padding: 0 10px;
  }
}
.img-box {
  margin-left: 19px;
  margin-bottom: 20px;
  display: flex;
  .cover {
    display: flex;
    flex-direction: column;
    img {
      width: 400px;
      height: 150px;
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
</style>
