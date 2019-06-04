
<template>
  <section>
    <!--用户详情-->
    <div class="detail-box">
      <ul>
        <li>用户名称：{{user.cuName}}</li>
        <li>用户状态：{{userStatusTxt[user.userStatus]}}</li>
        <li>设备状态：{{userStatusTxt[user.userStatus]}}</li>
        <li>会员状态：{{user.vipFlag === 'vip' ? '会员': '非会员' }}</li>
        <li>
          <el-button type="danger" size="mini" @click="lockDevice">冻结设备</el-button>
        </li>
      </ul>
      <ul>
        <li>总现金金额：{{user.rmbTotal}}</li>
        <li>当前可用现金余额：{{user.rmb}}</li>
        <li>总金豆数量：{{user.goldTotal || '--'}}</li>
        <li>当前可用金豆数量：{{user.gold}}</li>
        <li>
          <el-button type="danger" size="mini" @click="lockAccount">冻结账号</el-button>
        </li>
      </ul>
      <ul>
        <li>注册时间：{{user.regDate || '--'}}</li>
        <li>当前手机型号：{{user.phoneModel|| '--'}}</li>
        <li>客户端类型：{{user.source || '--'}}</li>
        <li>手机号码：{{user.bindPhone || '--'}}</li>
        <li>
          <el-button type="danger" size="mini" @click="phoneUpdate">修改手机号</el-button>
        </li>
      </ul>
      <ul>
        <li>邀请好友：{{user.invitedCuidList && user.invitedCuidList.length}}</li>
        <li>红包码：{{user.invitationCode}}</li>
        <li>最近上线时间：{{user.time || '--'}}</li>
        <li></li>
        <li class="link">
          <router-link :to="`/gifts/exchangeList/${_id}`">用户礼品兑换记录>></router-link>
        </li>
      </ul>
    </div>
    <detailList title="现金明细" :fetchHandle="getAccountFlow" type="rmb"/>
    <detailList title="金豆明细" :fetchHandle="getAccountFlow" type="gold"/>
  </section>
</template>

<script>
import { getAccountFlow, getAccountDetail } from "@/apis/user";
import detailList from "@/components/user/detailList";
export default {
  components: {
    detailList
  },
  computed: {
    _id() {
      return this.$route.params.id;
    },
    getAccountFlow() {
      return getAccountFlow;
    }
  },
  created() {
    this._id && this.getDetail();
  },
  data() {
    return {
      visible: false,
      user: {},
      userStatusTxt: {
        frozen: "封号",
        frozenByImei: "封设备",
        drawdown: "账户注销",
        normal: "正常"
      }
    };
  },
  methods: {
    getDetail() {
      let para = {
        cuId: this._id
      };
      getAccountDetail(para).then(({ data }) => {
        console.log(data)
        this.user = data.data;
        
      });
    },
    lockDevice() {},
    lockAccount() {},
    phoneUpdate() {
      this.$prompt("请输入需要绑定的手机号码", "修改手机号码", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputPattern: /^1[345789]\d{9}$/,
        inputErrorMessage: "手机号码格式不正确"
      })
        .then(({ value }) => {
          this.$alert("您确定要提交本次修改吗", "提示", {
            confirmButtonText: "确定"
          })
            .then(() => {
              this.$message({
                type: "success",
                message: "提交成功，你绑定的手机号为: " + value
              });
            })
            .catch(() => {
              this.$message({
                type: "info",
                message: "提交已取消"
              });
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    }
  }
};
</script>
<style lang="less" scoped>
.detail-box {
  display: flex;
  padding: 20px;
  background: #f4f4f4;
  font-size: 13px;
  color: #666;
  ul {
    width: 28%;
    li {
      height: 40px;
      line-height: 40px;
    }
    li.link {
      text-align: right;
    }
  }
}
</style>