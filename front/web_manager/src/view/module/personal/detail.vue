
<template>
  <section class="personal-detail">
    <!-- 书籍表单 -->
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="图标：" prop="picUrl" class="image-url">
        <el-upload
          class="avatar-uploader"
          action="/admin-free/upload/picture"
          :data="upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :on-error="errUpload"
          :on-progress="proUpload"
          >
          <img v-if="form.picUrl" :src="form.picUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          <input type="hidden" v-model="form.picUrl"/>
        </el-upload>
        <span :class="upload.status === true ? 'success':'fail'">{{ upload.tip }}</span>
      </el-form-item>
      <el-form-item label="主标题名称：" prop="mainTitle">
        <el-input v-model="form.mainTitle" placeholder="输入文字"/>
        <el-input v-model="form.mainTitleColor" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="副标题名称：" >
        <el-input v-model="form.subTitle" placeholder="输入文字"/>
        <el-input v-model="form.subTitleColor" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="次标题名称：" >
        <el-input v-model="form.threeTitle" placeholder="输入文字"/>
        <el-input v-model="form.threeTitleColor" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="跳转去向：" prop="direction">
        <el-select v-model="form.direction" >
          <el-option label="APP内跳转" :value="'app'"/>
          <el-option label="H5跳转" :value="'h5'"/>
        </el-select>
      </el-form-item>
      <el-form-item v-if="form.direction === 'app'" label="跳转地址：">
        <el-select v-model="form.directionType" placeholder="选择跳转页面">
          <el-option label="书架页" value='bookshelf'/>
          <el-option label="绑定手机" value='bindPhone'/>
          <el-option label="填红包码" value='rewardCode'/>
          <el-option label="我的钱包" value='wallet'/>
          <el-option label="我要提现" value='withdraw'/>
          <el-option label="邀请好友" value='invite'/>
          <el-option label="签到页" value='checkIn'/>
          <el-option label="福利页" value='welfare'/>
          <el-option label="书籍详情" value='book'/>
          <el-option label="开通会员" value='joinMembership'/>
          <el-option label="播放广告视频" value='video'/>
          <el-option label="分享" value='share'/>
        </el-select>
        <el-input v-if="form.directionType ==='book'" v-model.trim="form.bookID" placeholder="书籍ID" />
      </el-form-item>
      <el-form-item v-if="form.direction === 'h5'" label="跳转地址：">
        <el-input v-model.trim="form.link" placeholder="跳转地址" />
      </el-form-item>
      <el-form-item label="状态：">
        <el-select v-model="form.status" >
          <el-option label="上架" :value="1"/>
          <el-option label="下架" :value="0"/>
        </el-select>
      </el-form-item>
      <el-form-item label="排序：">
        <el-input type ="number" v-model="form.sort" placeholder="输入数字" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onValidate('form')">提交</el-button>
        <el-button type="info" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
import { getPersonalById, addPersonal, updatePersonal } from "@/apis/personal";
const LISTURL = "/module/personal";
export default {
  components: {},
  computed:{
    _id(){
      return this.$route.params.id;
    }
  },
  data() {
    return {
      listLoading:false,
      upload:{
        tip: '',
        folder: "personal",
        status: null
      },
      form: {
        picUrl: "",
        mainTitle: "",
        mainTitleColor: "",
        subTitle: "",
        subTitleColor: "",
        threeTitle: "",
        threeTitleColor: "",
        direction: "",
        directionType: "",
        bookID: "",
        link: "",
        directionPath: "",
        status: 1,
        sort: 1
      },
      rules:{
        picUrl: [
          { required: true, message: '请上传图标', trigger: 'blur' }
        ],
        mainTitle: [
          { required: true, message: '请输入主标题名称', trigger: 'blur' }
        ],
        direction: [
          { required: true, message: '请输入跳转地址', trigger: 'change' }
        ]
      }
    };
  },
  created(){
    this.$route.params.id && this.getDetail()
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
        let param = Object.assign({},this.form)
        let skipObj = {}
        if(param.direction ==='app'){
          let idStr = param.directionType === 'book' ? '://' + param.bookID : '';
          if(param.directionType === 'video'){
            Object.assign(skipObj,{
              linkType: 'video'
            })
          }else if(param.directionType === 'share'){
            Object.assign(skipObj,{
              linkType: 'share'
            })
          }else{
            Object.assign(skipObj,{
              linkType: 'share',
              url: param.directionType + idStr
            })
          }
        }else{
          Object.assign(skipObj,{
            linkType: 'h5',
            url: param.link
          })
        }
        param.directionPath = JSON.stringify(skipObj)
        delete param.createDate
        delete param.updateDate
        if(this._id){
          param = Object.assign(param,{
            id: this._id
          })
          updatePersonal(param).then(response => {
            this.go()
          })
        }else{
          addPersonal(param).then(response => {
            this.go()
          })
        }
      })
    },
    go(){
      this.$router.push(`/module/personal`)
    },
    getDetail(){
      getPersonalById({
        id: this._id
      }).then((res)=>{
        this.form = res.data.data
        let skipObj = Object.assign({},JSON.parse(this.form.directionPath));
        let obj = {}, url = skipObj.url;
        if(skipObj.linkType === 'app'){
          if(/book:/.test(url)){
            obj.directionType = url.split('://')[0]
            obj.bookID = url.split('://')[1]
          }else{
            obj.directionType = url
          }
        }else if(skipObj.linkType === 'video'){
          obj.directionType = 'video'
        }else if(skipObj.linkType === 'share'){
          obj.directionType = 'share'
        }else{
          obj.link = url
        }
        this.form = Object.assign({},this.form,obj)
      })
    },
    cancel(){
      this.$alert('您确定取消吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        this.$router.push(LISTURL)
      })
    },
    handleAvatarSuccess(res, file) {
      if (res.result !== "success") {
        this.$message.error(res.msg);
        this.upload.tip = '上传失败'
        this.upload.status = false
        return false;
      }
      this.form.picUrl = res.msg
      this.upload.status = true
      this.upload.tip = '上传成功'
      this.$refs.form.clearValidate('picUrl')
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
  .personal-detail{
    padding:30px 0;
    .el-input,.el-select{
      width:230px;
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