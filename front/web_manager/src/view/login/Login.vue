<template>
  <div class="login-wrap">
    <div class="ms-title">
      <img src="../../../static/img/LOGO.png" alt="">
    </div>
    <div class="ms-login">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="ms-content">
        <el-form-item prop="username">
          <el-input v-model="ruleForm.username" placeholder="账户名">
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="账户密码" v-model="ruleForm.password" @keyup.enter.native="submitForm('ruleForm')">
          </el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="danger" @click="submitForm('ruleForm')">登录</el-button>
        </div>
        <p class="login-tips">©2018qybook.net.co.ltd.all rights reserved</p>
      </el-form>
    </div>
    <div class="overlay"></div>
  </div>

</template>

<script>
import { setStore, getStore, removeStore, Utils } from "@/apis/mUtils";
import { requestLogin, requestlogout } from "@/apis/api";

export default {
  // this.fieldData2=this.fieldData.slice((value-1)*10,value*10) 模拟分页数据   vualue当前页数  fieldData全部数据  fieldData.len总数
  data: function() {
    return {
      ruleForm: {
        username: "",
        password: ""
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
      }
      // 注册界面
    };
  },
  mounted() {
    // console.log(this.$router.options)
    // console.log(Utils.rids())
  },
  methods: {
    //登陆
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          let para = {
            loginName: this.ruleForm.username,
            password: this.ruleForm.password
          };
          // setStore("ms_username", "admin");
          // this.$router.push("/");
          requestLogin(para)
            .then(res => {
              if (res.data.result == "success") {
                // console.log(res.data.data);
                setStore("ms_username", res.data.data.userName);
                setStore("username", res.data.data);
                setStore("permissions", res.data.data.roles[0].permissions);
                setStore("password", res.data.data.password);
                setStore("id", res.data.data.id);
                this.$message.success("登录成功");
                this.$router.push("/Dashboard");
              } else {
                this.$message.error("登录失败（请检查账户或密码是否错误）");
              }
            })
            .catch(() => {
              this.$message.error(`连接到服务器失败`);
            });
        } else {
          // console.log("登陆失败！");
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  height: 100%;
  min-width: 600px;
  max-height: 1200px;
  min-height: 700px;
  background-image: url(../../../static/img/background_img.jpg);
  background-size: 200%;
  animation: panning 150s infinite linear;
}

.ms-title {
  position: absolute;
  top: 25%;
  width: 100%;
  margin-top: -100px;
  text-align: center;
  /* display: flex;
  justify-content: center;
  align-items: center; */
}
.ms-title img {
  width: 9%;
  max-width: 150px;
  border-radius: 50%;
}
.ms-login {
  position: absolute;
  left: 50%;
  top: 60%;
  width: 450px;
  margin: -190px 0 0 -220px;
  border-radius: 5px;
  background: rgba(255, 255, 255, 0.3);
  overflow: hidden;
}
.ms-content {
  padding: 30px 30px;
}
.login-btn {
  text-align: center;
  margin-bottom: 50px;
}
.login-btn button {
  width: 100%;
  height: 36px;
  margin-bottom: 10px;
}
.login-tips {
  font-size: 14px;
  line-height: 30px;
  text-align: right;
  color: #474747;
}

@keyframes panning {
  0% {
    background-position: 0% 0%;
  }

  25% {
    background-position: 100% 100%;
  }

  50% {
    background-position: 100% 0%;
  }

  75% {
    background-position: 0 100%;
  }

  200% {
    background-position: 0 0;
  }
}
</style>