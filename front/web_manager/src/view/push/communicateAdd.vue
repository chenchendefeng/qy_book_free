
<template>
  <section class="communicate">
    <!-- 书籍表单 -->
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="头像：" prop="faceUrl" class="image-url">
        <el-upload
          class="avatar-uploader"
          action="/admin-free/upload/picture"
          :data="{folder:'communicate'}"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :on-error="errUpload"
          :on-progress="proUpload"
          >
          <img v-if="form.faceUrl" :src="form.faceUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          <input type="hidden" ref="faceUrl" v-model="form.faceUrl"/>
        </el-upload>
        <span :class="upload.status === true ? 'success':'fail'">{{ upload.tip }}</span>
      </el-form-item>
      <el-form-item label="昵称：" prop="nick">
        <el-input v-model="form.nick" placeholder="输入文字"/>
      </el-form-item>
       <el-form-item label="类型：" prop="type">
        <el-select v-model="form.type" >
          <el-option label="普通账户" :value="0"/>
          <el-option label="机器人帐号" :value="1"/>
        </el-select>
      </el-form-item>
      <el-form-item label="状态：" prop="status">
        <el-select v-model="form.status" >
          <el-option label="启用" :value="1"/>
          <el-option label="未启用" :value="0"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onValidate('form')">提交</el-button>
        <el-button type="info" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
import { communicateAcountAdd } from "@/apis/push";
export default {
  data() {
    return {
      listLoading:false,
      upload:{
        tip: '',
        status: null
      },
      form: {
        faceUrl: "",
        nick: "",
        type: 0,
        status: 1
      },
      rules:{
        faceUrl: [
          { required: true, message: '请上传头像', trigger: 'blur' }
        ],
        nick: [
          { required: true, message: '请输入昵称', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '请选择类型', trigger: 'change' }
        ],
        status: [
          { required: true, message: '请选择状态', trigger: 'change' }
        ]
      }
    };
  },
  methods: {
    onValidate(formName){
      this.$refs[formName].validate((valid) => {
        if(valid){
          this.onSubmit()
        } else {
          return false
        }
      })
    },
    onSubmit() {
      this.$alert('您确定提交吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
          communicateAcountAdd(this.form).then(response => {
            this.go()
          })
      })
    },
    go(){
      this.$router.push(`/push/communicate`)
    },
    cancel(){
      this.$alert('您确定取消吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        this.go()
      })
    },
    handleAvatarSuccess(res, file) {
      if (res.result !== "success") {
        this.$message.error(res.msg);
        this.upload.tip = '上传失败'
        this.upload.status = false
        return false;
      }
      this.form.faceUrl = res.msg
      this.upload.status = true
      this.upload.tip = '上传成功'
      this.$refs.form.clearValidate('faceUrl')
    },
    proUpload(response, file, fileList) {
      this.uploadText = `${Math.ceil(file.percentage)}%`;
    },
    errUpload() {
      this.upload.tip = '上传失败'
      this.upload.status = false
    },
  }
};
</script>
<style lang="less" scoped>
  .communicate{
    padding:30px 0;
    .el-input,.el-select{
      width:240px;
    }
    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 138px;
      height: 138px;
      line-height: 138px;
      text-align: center;
    }
    .avatar-uploader-icon:hover{
      border-color: #409EFF;
    }
    .avatar {
      max-width: 138px;
      max-height: 138px;
    }
    .success{
      color:#3c3;
    }
    .fail{
      color:red
    }
  }
</style>