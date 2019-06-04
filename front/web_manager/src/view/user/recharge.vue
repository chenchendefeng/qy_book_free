
<template>

  <section class="recharge">
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="用户信息：" prop="unionMsg">
        <el-input v-model="form.unionMsg" placeholder="用户ID/手机号码"></el-input>
        <el-button type="primary" @click="search">查询</el-button>
      </el-form-item>
      <el-form-item label="充值类型：" prop="rechargeType">
        <el-select v-model="form.rechargeType" >
          <el-option label="金豆" value="gold"/>
          <el-option label="现金" value="rmb"/>
        </el-select>
      </el-form-item>
      <el-form-item label="添加数量：" prop="num">
        <el-input type ="number" v-model="form.num" placeholder="输入数字" />
        {{ form.rechargeType === 'gold' ? '个' : '元'}}
      </el-form-item>
      <el-form-item>
        <div class="user-info" v-loading="listLoading">
          <ul>
            <li>用户昵称</li>
            <li>注册时间</li>
            <li>客户端类型</li>
            <li>当前金豆可用余额</li>
            <li>当前现金可用余额</li>
          </ul>
          <ul>
            <li>{{user.cuName || '--'}}</li>
            <li>{{user.regDate || '--'}}</li>
            <li>{{user.source || '--'}}</li>
            <li>{{user.gold || '--'}}</li>
            <li>{{user.rmb || '--'}}</li>
          </ul>
        </div>
      </el-form-item>
      <el-form-item label="备注：" prop="remark">
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="form.remark"
          maxlength="300"
          rows="4"
          show-word-limit
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">确认</el-button>
        <el-button type="info" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
import { getUsers, userRecharge} from "@/apis/user";
export default {
  components: {},
  data() {
    return {
      form: {
        unionMsg: "",
        rechargeType: "gold",
        num: "",
        remark: ""
      },
      user: {},
      listLoading: false,
      rules:{
        unionMsg: [
          { required: true, message: '请输入用户信息', trigger: 'change' }
        ],
        rechargeType: [
          { required: true, message: '请选择充值类型', trigger: 'change' }
        ],
        num: [
          { required: true, message: '请输入数量', trigger: 'change' }
        ],
        remark: [
          { required: true, message: '请添加备注', trigger: 'change' }
        ],
      }
    };
  },
  methods: {
    fetchData() {
      this.listLoading = true;
      let param = Object.assign({},{
        unionMsg: this.form.unionMsg,
        pageNo: 1,
        pageSize: 1
      })
      getUsers(param).then(({ data })=>{
        this.user = data.data.data[0] || {}
        this.listLoading = false;
      })
    },
    onSubmit(formName) {
      let param = Object.assign({},this.form,{
        cuId: this.user.cuId
      })
      if(this.form.rechargeType === 'rmb'){
        param = Object.assign(param,{
          num: param.num * 100
        })
      }
      delete param.unionMsg
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$alert('您确定提交吗', '提示', {
            confirmButtonText: '确定'
          }).then(() =>{
            userRecharge(param).then(res => {
              if(res.data.result !== 'success'){
                this.$message({
                  type: 'warning',
                  message: '充值失败!'
                })
                return;
              }
              this.fetchData()
              this.$message({
                type: 'success',
                message: '充值成功!'
              })
              this.form = Object.assign(this.form,{
                rechargeType: '',
                num: '',
                remark: ''
              })
              this.$refs[formName].resetFields()
            })
          })
        } else {
          return false
        }
      })
    },
    cancel(){
      this.$alert('您确定取消吗', '提示', {
        confirmButtonText: '确定'
      }).then(()=>{
        this.$refs['form'].resetFields()
      })
    },
    search(){
      this.$refs['form'].validateField('unionMsg', err =>{
        if(!err){
          this.fetchData()
        }
      })
    }
  }
};
</script>

<style lang="less" scoped>
  .recharge{
    padding:30px 0;
    .el-input{
      width:193px;
    }
    .el-textarea{
      width: 500px;
    }
    .user-info{
      width: 80%;
      font-size: 12px;
      color:#555;
      margin: 20px 0;
      ul{
        display: flex;
        border-bottom: solid 1px #ccc;
        li{
          width: 25%;
          padding:5px 10px;
        }
      }
      ul:first-child{
        background: #eee;
      }
      ul:last-child:hover{
        background: #f6faff;
      }
    }
  }
</style>