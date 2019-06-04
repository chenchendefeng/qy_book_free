<template>
  <div class="peizhi">
    <el-form ref="addForm" :model="addForm" label-width="110px" :rules="addFormRules">
      <el-form-item label="文件类型：">
        <el-select v-model="addForm.fileType" placeholder="选择" style="width: 220px;">
          <el-option label="图片" :value="'pic'">
          </el-option>
          <el-option label="动图" :value="'gif'">
          </el-option>
          <el-option label="视频" :value="'video'">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="文件地址：" prop="fileUrl">
        <!-- :before-upload="beforeAvatarUpload"  -->
        <div class="cover">
          <el-input v-model="addForm.fileUrl" style="width: 40%;" @keyup.enter.native="dialogImageUrl1=addForm.fileUrl" @blur="dialogImageUrl1=addForm.fileUrl"></el-input>
          <span>或</span>
          <el-upload class="upload" action="/admin-free/startPage/upload" list-type="picture-card" :on-error="errUpload" accept="image/*,video/*" :on-success="handlePictureCardPreview" :on-progress="proUpload" :file-list="fileList" :limit="1">
            <el-button size="small">上传文件</el-button>
          </el-upload>
          <span v-text="text1" style=" color:red;margin-left: 10px;"></span>
        </div>
      </el-form-item>
      <div class="img-box">
        <div class="cover1">
          <span>封面阅览：</span>
          <div class="vide-img">
            <img v-if="addForm.fileType=='pic' && dialogImageUrl1" :src="dialogImageUrl1" alt="" class="img1" style=" width: 110px;height: 150px;">
            <img v-if="addForm.fileType=='gif' && dialogImageUrl1" :src="dialogImageUrl1" alt="" class="img1" style=" width: 110px;height: 150px;">
            <video v-if="addForm.fileType==`video` && dialogImageUrl1" :src="dialogImageUrl1" controls controlsList="nodownload" style="width: 110px;height: 150px; ">
              您的浏览器不支持 video 标签。
            </video>
          </div>
        </div>
      </div>

      <el-form-item label="开始时间：" prop="beginDate">
        <el-date-picker v-model="addForm.beginDate" type="datetime" placeholder="选择日期时间" value-format="yyyy-MM-dd HH:mm:ss" :picker-options="pickerOptions0">
        </el-date-picker>
      </el-form-item>

      <el-form-item label="结束时间：" prop="endDate">
        <el-date-picker v-model="addForm.endDate" type="datetime" placeholder="选择日期时间" value-format="yyyy-MM-dd HH:mm:ss" :picker-options="pickerOptions1">
        </el-date-picker>
      </el-form-item>

      <el-form-item label="状态：">
        <el-select v-model="addForm.status" placeholder="有效" style="width: 220px;">
          <el-option label="启用" :value="1">
          </el-option>
          <el-option label="停用" :value="0">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="渠道：">
        <el-input v-model="addForm.channelCodes" style="width: 220px;" placeholder="单行输入"></el-input><br>
        <span>渠道为空时，对所有可见，多渠道并存是用 , 隔开</span>
      </el-form-item>

      <el-form-item label="客户端：">
        <el-radio-group v-model="addForm.clientType">
          <el-radio :label="`all`">全部</el-radio>
          <el-radio :label="`ios`">IOS</el-radio>
          <el-radio :label="`Android`">Android</el-radio>
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
import { startPaUpdate, stOSSFile } from "@/apis/api";
export default {
  data() {
    return {
      addForm: {
        fileType: "pic",
        fileUrl: "",
        beginDate: "",
        endDate: "",
        status: 1,
        channelCodes: "",
        clientType: "all"
      },
      addFormRules: {
        beginDate: [{ required: true, message: "请填写内容", trigger: "blur" }],
        endDate: [{ required: true, message: "请填写内容", trigger: "blur" }],
        fileUrl: [{ required: true, message: "请填写地址", trigger: "change" }]
      },
      dialogImageUrl1: "",
      fileList: [],
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
            startPaUpdate(this.addForm).then(res => {
              console.log(res);
              if (res.data.result !== "success") {
                this.$message.error(`添加或修改失败`);
                return false;
              }
              this.$message.success("添加或修改成功");
            });
            this.$emit("hiden");
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

    // 上传前
    // beforeAvatarUpload(file) {
    // },
    // 上传时
    proUpload(response, file, fileList) {
      this.text1 = `${Math.ceil(file.percentage)}%`;
      // console.log(file);
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
      this.addForm.fileUrl = response.msg;
      this.dialogImageUrl1 = response.msg;

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
      this.dialogImageUrl1 = e.fileUrl;
    }
  },

  mounted() {
    this.addForm = this.poplist;
    this.dialogImageUrl1 = this.poplist.fileUrl;
    this.text1 = "";
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
    .vide-img {
      border: 1px solid #ccc;
      width: 110px;
      height: 150px;
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
