
<template>
  <section class="welfare-detail">
    <!-- 书籍表单 -->
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="福利类型：" prop="type">
        <el-select v-model="form.type" >
          <el-option label="新人福利" value="novice"/>
          <el-option label="阅读福利" value="read"/>
          <el-option label="日常福利" value="daily"/>
        </el-select>
      </el-form-item>
      <el-form-item label="奖励类型：" prop="rewardType">
        <el-select v-model="form.rewardType" >
          <el-option label="现金" value="rmb"/>
          <el-option label="金豆" value="gold"/>
        </el-select>
      </el-form-item>
      <el-form-item label="主标题名称：" prop="mainTitle">
        <el-input v-model.trim="form.mainTitle" placeholder="输入文字"/>
        <el-input v-model.trim="form.mainTitleColor" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="副标题名称：" >
        <el-input v-model.trim="form.subTitle" placeholder="输入文字"/>
        <el-input v-model.trim="form.subTitleColor" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="奖励数量：" prop="minNum">
        <el-input class="w" type="number" v-model="form.minNum" placeholder="输入数字"/> 至
        <el-input class="w" type="number" v-model="form.maxNum" placeholder="输入数字"/>
      </el-form-item>
      <el-form-item label="跳转去向：" prop="skipType">
        <el-select v-model="form.skipType" >
          <el-option label="APP内跳转" :value="'app'"/>
          <el-option label="H5跳转" :value="'h5'"/>
        </el-select>
      </el-form-item>
      <el-form-item v-if="form.skipType === 'app'" label="跳转地址：">
        <el-select v-model="form.sType" placeholder="选择跳转页面">
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
        <el-input v-if="form.sType ==='book'" v-model.trim="form.bookID" placeholder="书籍ID" />
      </el-form-item>
      <el-form-item v-if="form.skipType === 'h5'" label="跳转地址：">
        <el-input v-model.trim="form.link" placeholder="跳转地址" />
      </el-form-item>
      <el-form-item label="按钮文案：" prop="buttonTex">
        <el-input v-model.trim="form.buttonTex" placeholder="按钮文案" />
      </el-form-item>
      <el-form-item label="图标文案：" prop="iconTex">
        <el-input v-model.trim="form.iconTex" placeholder="图标文案" />
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
import { getWelfareDetail, addWelfare, updateWelfare } from "@/apis/welfare";
export default {
  components: {},
  computed:{
    _id(){
      return this.$route.params.id;
    },
    type(){
      return this.$route.params.type;
    }
  },
  data() {
    return {
      listLoading:false,
      form: {
        type: this.$route.params.type,
        rewardType: "rmb",
        mainTitle: "",
        mainTitleColor: "",
        subTitle: "",
        subTitleColor: "",
        minNum: "",
        maxNum: "",
        skipType: "app",
        skipPage: "",
        sType: "",
        link: "",
        buttonTex: "",
        iconTex: "",
        status: 1,
        sort: "1",
      },
      rules:{
        type: [
          { required: true, message: '请选择福利类型', trigger: 'change' }
        ],
        rewardType: [
          { required: true, message: '请选择奖励类型', trigger: 'change' }
        ],
        mainTitle: [
          { required: true, message: '请填写主标题', trigger: 'blur' }
        ],
        skipType: [
          { required: true, message: '请选择跳转类型', trigger: 'change' }
        ],
        minNum: [
          { required: true, message: '请填写奖励数量', trigger: 'blur' }
        ],
        buttonTex: [
          { required: true, message: '请填写按钮文案', trigger: 'blur' }
        ],
        iconTex: [
          { required: true, message: '请填写图标文案', trigger: 'blur' }
        ],
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
        delete param.createTime
        delete param.updateTime
        let skipObj = {}
        if(param.skipType ==='app'){
          let idStr = param.sType === 'book' ? '://' + param.bookID : '';
          if(param.sType === 'video'){
            Object.assign(skipObj,{
              linkType: 'video'
            })
          }else if(param.sType === 'share'){
            Object.assign(skipObj,{
              linkType: 'share'
            })
          }else{
            Object.assign(skipObj,{
              linkType: 'app',
              url: param.sType + idStr
            })
          }
        }else{
          Object.assign(skipObj,{
            linkType: 'h5',
            url: param.link
          })
        }
        param.skipPage = JSON.stringify(skipObj)
        if(this._id){
          param = Object.assign(param,{
            id: this._id
          })
          updateWelfare(param).then(response => {
            this.go()
          })
        }else{
          addWelfare(param).then(response => {
            this.go()
          })
        }
      })
    },
    getDetail(){
      getWelfareDetail({
        id: this._id
      }).then((res)=>{
        this.form = res.data.data
        let skipObj = Object.assign({},JSON.parse(this.form.skipPage));
        let obj = {}, url = skipObj.url;
        if(skipObj.linkType === 'app'){
          if(/book:/.test(url)){
            obj.sType = url.split('://')[0]
            obj.bookID = url.split('://')[1]
          }else{
            obj.sType = url
          }
        }else if(skipObj.linkType === 'video'){
          obj.sType = 'video'
        }else if(skipObj.linkType === 'share'){
          obj.sType = 'share'
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
        this.go()
      })
    },
    go(){
      this.$router.push(`/module/welfare/${this.type}`)
    }
  }
};
</script>

<style lang="less" scoped>
  .welfare-detail{
    padding:10px 0 30px;
    .el-input,.el-select{
      width:240px;
    }
    .el-input.w{
      width: 108px;
    }
  }
</style>