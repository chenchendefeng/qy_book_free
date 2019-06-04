<template>
  <div class="peizhi">
    <el-form ref="addForm" :model="addForm" label-width="110px" :rules="addFormRules">
      <el-form-item label="文件地址：" prop="img">
        <div class="cover">
          <el-input
            v-model="addForm.img"
            style="width: 40%;"
            @keyup.enter.native="dialogImageUrl1=addForm.img"
            @blur="dialogImageUrl1=addForm.img"
          ></el-input>
          <span>或</span>
          <el-upload
            class="upload"
            action="/admin-free/upload/picture"
            :data="{folder:'popupWindow'}"
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
          <span v-text="text1" style=" color:red;margin-left: 10px;"></span>
        </div>
      </el-form-item>
      <div class="img-box">
        <div class="cover1">
          <span>文件阅览：</span>
          <img :src="dialogImageUrl1" alt class="img1">
        </div>
      </div>

      <el-form-item label="显示规则：">
        <el-select v-model="addForm.showType" placeholder="一直显示">
          <el-option :label="item" :value="index" v-for="(item ,index) of showTypes" :key="index"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="弹窗位置：">
        <el-select v-model="addForm.showPage" placeholder="弹窗位置">
          <el-option
            v-for="(value, key ,index) of showPages"
            :label="value"
            :value="key"
            :key="index"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="弹窗大小：">
        <el-select v-model="addForm.windowType" placeholder="正常">
          <el-option :label="item" :value="index" v-for="(item ,index) of windowTypes" :key="index"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="跳转去向：" prop="skipType">
        <el-select v-model="addForm.skipType">
          <el-option label="APP内跳转" :value="0"/>
          <el-option label="H5跳转" :value="1"/>
        </el-select>
      </el-form-item>
      <el-form-item v-if="addForm.skipType === 0" label="跳转地址：">
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
      <el-form-item v-if="addForm.skipType === 1" label="跳转地址：">
        <el-input v-model.trim="addForm.link" placeholder="跳转地址"/>
      </el-form-item>

      <el-form-item label="开始时间：" prop="startTime">
        <el-date-picker
          v-model="addForm.startTime"
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

      <el-form-item label="弹窗状态：">
        <el-select v-model="addForm.status" placeholder="有效">
          <el-option :label="item" :value="index" v-for="(item ,index) of popStatus" :key="index"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="弹窗渠道：">
        <el-input v-model="addForm.channel" placeholder="单行输入"></el-input>
        <br>
        <span>渠道为空时，对所有可见，多渠道并存是用 , 隔开</span>
      </el-form-item>

      <el-form-item label="弹窗状态：">
        <el-radio-group v-model="addForm.clientType">
          <el-radio :label="'all'">全部</el-radio>
          <el-radio :label="'IOS'">IOS</el-radio>
          <el-radio :label="'Android'">Android</el-radio>
          <el-radio :label="'H5'">H5</el-radio>
          <el-radio :label="'PC'">PC</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
    <div class="foot">
      <div class="login-btn">
        <el-button v-if="add" type="danger" @click="onSubmit">确定</el-button>
        <el-button v-else type="danger" @click="onSubmit">确定</el-button>
      </div>
      <div class="login-btn">
        <el-button type="info" @click="go('addForm')">取消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { popupWindowadd, popupWinupdate, popactivilist } from "@/apis/api";
export default {
  data() {
    return {
      windowTypes: ["大窗", "小窗"],
      showTypes: ["点击消失", "一直显示"],
      showPages: {
        recommend: "推荐专区",
        boy: "男生专区",
        girl: "女生专区",
        personalCenter: "个人中心",
        categoryBoy: "分类-男生",
        categoryGirl: "分类-女生"
      },
      popStatus: ["下架", "上架"],
      addForm: {
        showType: 1,
        windowType: 0,
        showPage: "boy",
        clientType: "all",
        status: 1,
        channel: "",
        startTime: "",
        endTime: "",
        skipType: 0,
        skipPage: "",
        sType: "",
        link: "",
        img: ""
      },
      fileList: [],
      addFormRules: {
        img: [{ required: true, message: "请填写图片地址", trigger: "change" }],
        startTime: [{ required: true, message: "请填写内容", trigger: "blur" }],
        endTime: [{ required: true, message: "请填写内容", trigger: "blur" }]
      },
      dialogImageUrl1: "",
      dialogImageUrl2: "",
      text1: "",
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
            if (param.skipType === 0) {
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
            param.skipPage = JSON.stringify(skipObj);
            if (this.add) {
              popupWindowadd(param).then(res => {
                if (res.data.msg !== "添加成功") {
                  this.$message.error(`添加失败`);
                  return false;
                }
                this.$message.success("添加成功");
              });
            } else {
              param = Object.assign({}, param, {
                id: this.poplist.id
              });
              popupWinupdate(param).then(res => {
                if (res.data.msg !== "更新成功") {
                  this.$message.error(`更新失败`);
                  return false;
                }
                this.$message.success("修改成功");
              });
            }
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
      this.addForm.img = response.msg + "";
      this.dialogImageUrl1 = response.msg;
      this.text1 = "上传成功";
    },
    //上传失败
    errUpload() {
      this.fileList = [];
      this.text1 = "上传失败";
    },
    setSkip() {
      console.log(this.addForm.skipPage)
      let skipObj = Object.assign({}, JSON.parse(this.addForm.skipPage));
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
      this.text1 = "";
      this.addForm = e;
      this.dialogImageUrl1 = e.img;
      this.setSkip();
    }
  },
  mounted() {
    this.text1 = "";
    this.addForm = this.poplist;
    this.dialogImageUrl1 = this.poplist.img;
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
}
.login-btn button {
  width: 120px;
  height: 36px;
  margin: 0 30px;
}

.cover {
  display: flex;
  span {
    padding: 0 10px;
  }
}

.img-box {
  margin-left: 28px;
  margin-bottom: 20px;
  display: flex;
  .cover1 {
    display: flex;
    img {
      width: 130px;
      height: 130px;
      border: 1px solid #ccc;
    }
    span {
      padding: 0 10px 0 0;
    }
  }
}
.demo {
  display: inline-block;
  width: 70px;
  padding-left: 10px;
}
</style>
