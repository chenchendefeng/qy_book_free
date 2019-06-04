
<template>
  <section class="gifts-detail">
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="礼品类型：" prop="exchangeType">
        <el-select v-model="form.exchangeType" >
          <el-option label="金豆" :value="'gold'"/>
          <el-option label="人民币" :value="'rmb'"/>
        </el-select>
      </el-form-item>
      <el-form-item label="礼品名称：" prop="name">
        <el-input v-model="form.name" placeholder="单行输入"/>
      </el-form-item>
      <el-form-item label="礼品消耗：" prop="cost">
        <el-input type="number" v-model="form.cost" placeholder="根据礼品类型不同，消耗对象不同"/> 
        <span>{{form.exchangeType === 'rmb' ? '人民币' : '金豆' }}</span>
      </el-form-item>
      <el-form-item label="兑换条件：" prop="requirement">
        <el-select v-model="form.requirement"  class="w1" >
          <el-option label="VIP会员" :value="'VIP'"/>
          <el-option label="阅读时长" :value="'readTime'"/>
          <el-option label="所有" :value="'all'"/>
        </el-select>
        <el-input type="number" v-model="form.requirementNumber" class="w1"/>
        <span v-if="form.requirement==='readTime'"> 分钟</span>
      </el-form-item>
      <el-form-item label="备注：">
        兑换条件选择为“阅读时长”时，输入框内数字单位为分钟
      </el-form-item>
      <el-form-item label="提示角标：">
        <el-input v-model="form.marker" placeholder="单行输入"/>
      </el-form-item>
      <el-form-item label="礼品状态：">
        <el-select v-model="form.status" >
          <el-option label="上架" :value="1"/>
          <el-option label="下架" :value="0"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">提交</el-button>
        <el-button type="info" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
import { getGiftById, addGift, updateGift } from "@/apis/gifts";
export default {
  computed:{
    _id(){
      return this.$route.params.id;
    }
  },
  data() {
    return {
      listLoading:false,
      form: {
        exchangeType: "",
        name: "",
        status: 1,
        cost: "",
        marker: ""
      },
      rules:{
        exchangeType: [
          { required: true, message: '请选择礼品类型', trigger: 'change' }
        ],
        name: [
          { required: true, message: '请输入礼品名称', trigger: 'change' }
        ],
        cost: [
          { required: true, message: '请输入礼品消耗量', trigger: 'change' }
        ],
        requirement: [
          { required: true, message: '请选择兑换条件', trigger: 'change' }
        ]
      }
    };
  },
  created(){
    this.$route.params.id && this.getDetail()
  },
  methods: {
    onSubmit(formName) {
      let param = this.form
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$alert('您确定提交吗', '提示', {
            confirmButtonText: '确定'
          }).then(() =>{
            delete param.createTime
            delete param.updateTime
            if(this._id){
              param = Object.assign({},param,{
                id: this._id
              })
              updateGift(param).then(() => {
                this.go()
              })
            }else{
              addGift(param).then(() => {
                this.go()
              })
            }
          })
        } else {
          return false
        }
      })
    },
    go(){
      this.$router.push('/gifts/list')
    },
    getDetail(){
      getGiftById({
        id: this._id
      }).then((res)=>{
        this.form = res.data.data
      })
    },
    cancel(){
      this.$alert('您确定取消吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        this.$router.push(LISTURL)
      })
    }
  }
};
</script>
<style lang="less" scoped>
  .gifts-detail{
    padding:30px 0;
    .el-input,.el-select{
      width:260px;
    }
    .w1{
      width: 127px;
    }
  }
</style>