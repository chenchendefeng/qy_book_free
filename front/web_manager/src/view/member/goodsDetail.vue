
<template>
  <section class="goods-detail">
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="商品名称：" prop="goodsName">
        <el-input v-model="form.goodsName" placeholder="单行输入"/>
      </el-form-item>
      <el-form-item label="商品价格：" prop="goodsPrice">
        <el-input type="number" v-model="form.goodsPrice" placeholder="小数点后两位，例如：8.88"/> 元
      </el-form-item>
      <el-form-item label="商品数量：" prop="goodsNum">
        <el-input type="number" v-model="form.goodsNum"/> 天
      </el-form-item>
      <el-form-item label="副标题：">
        <el-input :disabled="!!form.noticeMsg" v-model="form.goodsMsg" />
      </el-form-item>
      <el-form-item label="副标颜色：">
        <el-input v-model="form.goodsMsgColor" placeholder="RGB值"/>
      </el-form-item>
      <el-form-item label="提示角标：">
        <el-input :disabled="!!form.goodsMsg" v-model="form.noticeMsg" placeholder="单行输入"/>
      </el-form-item>
      <el-form-item label="备注：">
        副标题和提示角标不可并存
      </el-form-item>
      <el-form-item label="商品状态：">
        <el-select v-model="form.saleStatus" >
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
import { getGoodsDetail, saveOrUpdateGoods } from "@/apis/member";
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
        goodsName: "",
        goodsPrice:"",
        goodsType: "vip",
        goodsMsg: "",
        goodsMsgColor: "",
        saleStatus: 1,
        goodsNum: "",
        noticeMsg: ""
      },
      rules:{
        goodsName: [
          { required: true, message: '请输入商品名称', trigger: 'change' }
        ],
        goodsPrice: [
          { required: true, message: '请输入商品价格', trigger: 'change' }
        ],
        goodsNum: [
          { required: true, message: '请输入商品数量', trigger: 'change' }
        ]
      }
    };
  },
  created(){
    this.$route.params.id && this.getDetail()
  },
  methods: {
    onSubmit(formName) {
      let param = Object.assign({},this.form,{
        goodsPrice: this.form.goodsPrice * 100
      })
      if(this._id){
        param = Object.assign({},param,{
          id: this._id
        })
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$alert('您确定提交吗', '提示', {
            confirmButtonText: '确定'
          }).then(() =>{
            delete param.createTime
            delete param.updateTime
            saveOrUpdateGoods(param).then(response => {
              this.go()
            })
          })
        } else {
          return false
        }
      })
    },
    getDetail(){
      getGoodsDetail({
        id: this._id
      }).then((res)=>{
        this.form = res.data.data
        this.form.goodsPrice = (this.form.goodsPrice / 100).toFixed(2)
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
      this.$router.push('/member/goods')
    }
  }
};
</script>
<style lang="less" scoped>
  .goods-detail{
    padding:10px 0 30px;
    .el-input,.el-select{
      width:300px;
    }
  }
</style>