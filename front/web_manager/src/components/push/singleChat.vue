<template>
  <div>
    <el-card class="box-card group-box">
      <el-form ref="form" :model="form" label-width="100px" :rules="addFormRules">
        <el-form-item label="发送方ID" prop="fromIdentifier">
          <el-select v-model="form.fromIdentifier" placeholder="请选择">
            <el-option
              v-for="(item,index) in poplist"
              :key="index"
              :label="item.nick"
              :value="item.identifier"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="接受方ID" prop="toIdentifier">
          <el-input v-model="form.toIdentifier" style="width: 215px;" placeholder="单行输入"></el-input>
        </el-form-item>

        <el-form-item label="推送标题" prop="title">
          <el-input v-model="form.title" style="width: 80%;" placeholder="单行输入"></el-input>
        </el-form-item>

        <el-form-item label="推送内容" prop="content">
          <el-input
            type="textarea"
            v-model="form.content"
            style="width: 80%;"
            :autosize="{ minRows: 6, maxRows: 6}"
          ></el-input>
        </el-form-item>

        <el-form-item label="文件类型：">
          <el-select
            v-model="form.fileType"
            placeholder="选择"
            style="width: 220px;"
            @change="fileUrl"
          >
            <el-option label="无" :value="``"></el-option>
            <el-option label="图片" :value="`picture`"></el-option>
            <el-option label="视频" :value="`video`"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label prop="roleName">
          <div class="cover">
            <el-upload
              class="upload"
              action="/admin/startPage/upload"
              list-type="picture-card"
              :on-error="errUpload"
              accept="image/*, video/*"
              :on-success="handlePictureCardPreview"
              :on-progress="proUpload"
              :file-list="fileList"
              :disabled="!form.fileType" 
              :limit="1"
            >
              <el-button :disabled="!form.fileType" size="small">上传文件</el-button>
            </el-upload>

            <div class="img-box">
              <div class="cover1">
                <div class="vide-img" @click="dialogVisible=true">
                  <img
                    v-if="form.fileType== `picture` && form.fileUrl"
                    :src="form.fileUrl"
                    alt
                    class="img1"
                    style=" width: 50px;height: 50px;"
                  >
                  <video
                    v-if="form.fileType==`video` && form.fileUrl"
                    :src="form.fileUrl"
                    controls
                    controlslist="nodownload"
                    style="width: 50px;height: 50px; "
                  >您的浏览器不支持 video 标签。</video>
                </div>
              </div>
            </div>
            <span v-text="text1" style=" color:red;"></span>
          </div>
        </el-form-item>

        <el-dialog :visible.sync="dialogVisible" v-if="form.fileUrl" align="center">
          <img
            v-if="form.fileType== `picture` && form.fileUrl"
            width="200px"
            :src="form.fileUrl"
            alt
            class="img1"
          >
          <video
            v-if="form.fileType==`video` && form.fileUrl"
            :src="form.fileUrl"
            style="width: 200px;height: 150px; "
            controls
            controlslist="nodownload"
          >您的浏览器不支持 video 标签。</video>
        </el-dialog>

        <el-form-item label="跳转类型：">
          <el-select
            v-model="form.jumpType"
            placeholder="选择跳转类型"
            style="width: 220px;"
            @change="linkUrl"
          >
            <el-option label="不跳转" :value="``"></el-option>
            <el-option label="APP内跳转" :value="`app`"></el-option>
            <el-option label="H5跳转" :value="`h5`"></el-option>
            <el-option label="书籍详情跳转" :value="`book`"></el-option>
            <el-option label="大神跳转" :value="`famouse`"></el-option>
            <el-option label="导读跳转" :value="`guide`"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="跳转地址：" v-if="form.jumpType != ``">
          <div class="cover">
            <el-input
              v-if="form.jumpType == `h5`"
              v-model="form.directionPath"
              style="width: 40%;"
              placeholder="跳转地址"
            ></el-input>
            <div v-else-if="form.jumpType == `app`">
              <el-select v-model="form.directionPath" placeholder="选择跳转页面" style="width: 150px;">
                <el-option label="充值" value="recharge"></el-option>
                <el-option label="vip" value="vip"></el-option>
                <el-option label="绑定手机" value="bindPhone"></el-option>
              </el-select>
            </div>
            <el-input
              v-else
              v-model="skipUrlinput"
              placeholder="输入ID"
              style="width: 40%;"
              @keyup.enter.native="form.directionPath=form.jumpType+`://`+skipUrlinput"
              @blur="form.directionPath=form.jumpType+`://`+skipUrlinput"
            ></el-input>
          </div>
        </el-form-item>

        <el-form-item label="性别">
          <el-radio-group v-model="form.gender">
            <el-radio :label="``">全部</el-radio>
            <el-radio :label="1">男</el-radio>
            <el-radio :label="2">女</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="定时">
          <el-switch v-model="form.timing" :active-value="1" :inactive-value="0"></el-switch>
          <el-date-picker
            v-if="form.timing"
            v-model="form.sendTimeStr"
            type="datetime"
            placeholder="选择日期时间"
            value-format="yyyy-MM-dd HH:mm:ss"
            :picker-options="pickerOptions0"
          ></el-date-picker>
        </el-form-item>
      </el-form>
      <div class="foot">
        <div class="login-btn">
          <el-button type="danger" @click="onSubmit" :disabled="bat">确定</el-button>
        </div>
        <div class="login-btn">
          <el-button type="info">取消</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>
<script>
import {
  communicationMessageinsert,
  communicationAcountpage
} from "@/apis/api";
import { mapState, mapMutations } from "vuex";
export default {
  data() {
    return {
      bat: true,
      skipUrlinput: "",
      form: {
        directionPath: "",
        toIdentifier: "",
        fileType: "",
        fileUrl: "",
        jumpType: "",
        gender: "",
        sendTimeStr: "",
        msgType: 1,
        fromIdentifier: "",
        title: "",
        content: "",
        timing: 0
      },
      addFormRules: {
        title: [{ required: true, message: "请填写内容", trigger: "blur" }],
        toIdentifier: [
          { required: true, message: "请填写内容", trigger: "blur" }
        ],
        content: [{ required: true, message: "请填写内容", trigger: "blur" }],
        fromIdentifier: [
          { required: true, message: "请填写内容", trigger: "blur" }
        ]
      },
      poplist: "",
      text1: "",
      fileList: [],
      dialogVisible: false,
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() <= Date.now() - 8.64e7;
        }
      }
    };
  },
  methods: {
    Acountpage() {
      let para = {
        pageNo: 1,
        pageSize: 100
      };
      communicationAcountpage(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取失败`);
          return false;
        }
        this.poplist = res.data.data.data;
      });
    },

    linkUrl() {
      this.skipUrlinput = "";
      this.form.directionPath = "";
    },

    fileUrl() {
      this.text1 = "";
      this.form.fileUrl = "";
    },
    ...mapMutations(["rmove"]),

    onSubmit() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.$confirm("确认提交吗?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          }).then(() => {
            let para = this.form;
            communicationMessageinsert(para).then(res => {
              if (res.data.result !== "success") {
                this.$message.error(res.data.msg);
                return false;
              }
              this.bat = true;
              this.$message.success("成功");
            });
          });
        } else {
          this.$message.warning("请输入完整信息");
        }
      });
    },

    // 上传时
    proUpload(response, file, fileList) {
      this.text1 = `${Math.ceil(file.percentage)}%`;
    },
    //上传成功
    handlePictureCardPreview(response, file, fileList) {
      this.fileList = [];
      // console.log(response)
      if (response.result !== "success") {
        this.$message.error(response.msg);
        this.text1 = "上传失败";
        return false;
      }
      this.form.fileUrl = response.msg;
      this.text1 = "上传成功";
    },
    //上传失败
    errUpload() {
      this.fileList = [];
      this.text1 = "上传失败";
    }
  },
  // 获取用户数据
  mounted() {
    console.log(this.$store.state.tuiuid);
    if (this.$store.state.tuisong == "second") {
      this.form.toIdentifier = this.$store.state.tuiuid;
    }
    this.Acountpage();
  },
  computed: {
    currentuid() {
      return this.$store.state.tuiuid;
    }
  },
  watch: {
    currentuid(e) {
      if (this.$store.state.tuisong == "second") {
        this.form.toIdentifier = e;
        console.log(e, "推送");
      }
    },
    form: {
      handler(val, oldVal) {
        this.bat = false;
      },
      deep: true
    }
  },
  destroyed() {
    this.rmove();
  }
};
</script>


<style lang="less" scoped>
.img-box {
  margin: 0 10px;

  display: flex;
  .cover1 {
    display: flex;
    .vide-img {
      border: 1px solid #ccc;
      width: 50px;
      height: 50px;
      cursor: pointer;
    }
    span {
      padding: 0 10px 0 0;
    }
  }
}
.group-box {
  width: 90%;
  margin: 0 auto;
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
  align-items: center;
}
</style>
