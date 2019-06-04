
<template>
  <section class="recharge">
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="用户信息：" prop="uid">
        <el-input v-model="form.uid" placeholder="用户ID/手机号码"></el-input>
        <el-button type="primary">查询</el-button>
      </el-form-item>
      <el-form-item label="添加天数：" prop="amount">
        <el-input type ="number" v-model="form.amount" placeholder="输入数字" /> 天
      </el-form-item>
      <el-form-item>
        <div class="user-info">
          <ul>
            <li>用户昵称</li>
            <li>注册时间</li>
            <li>客户端类型</li>
            <li>会员截止日期</li>
          </ul>
          <ul>
            <li>----</li>
            <li>----</li>
            <li>----</li>
            <li>----</li>
          </ul>
        </div>
      </el-form-item>
      <el-form-item label="备注：">
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="form.note"
          maxlength="300"
          rows="4"
          show-word-limit
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">确认</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      form: {
        uid: "",
        type: "",
        amount: "",
        note: ""
      },
      rules:{
        uid: [
          { required: true, message: '请输入用户信息', trigger: 'change' }
        ],
        amount: [
          { required: true, message: '请输入天数', trigger: 'change' }
        ]
      }
    };
  },
  methods: {
    onSubmit(formName) {
      const param = this.form
      this.$refs[formName].validate((valid) => {
        if (valid) {
          updateBookDetail(param).then(response => {
            this.visible = false
            this.fetchData()
            this.$message({
              type: 'success',
              message: '修改成功!'
            })
          })
        } else {
          return false
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