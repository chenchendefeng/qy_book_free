<template>

  <div class="details">
    <div class="details-ul">
      <div class="details-li1">用户ID</div>
      <div class="details-li2">{{users.uid}}</div>
      <div class="details-li3">用户昵称</div>
      <div class="details-li4">
        <span>{{users.name}}</span>
        <el-button size="mini" @click="nicheng">修改</el-button>
      </div>
    </div>
    <div class="details-ul">
      <div class="details-li1">手机型号</div>
      <div class="details-li2" v-if="users.phoneModel">{{users.phoneModel}}</div>
      <div class="details-li2" v-else>暂无</div>
      <div class="details-li3">手机号码</div>
      <div class="details-li4">
        <span v-if="users.bindPhone">{{users.bindPhone}}</span>
        <span v-else>暂无</span>
        <el-button size="mini" @click="haoma">修改</el-button>
      </div>
    </div>
    <div class="details-ul">
      <div class="details-li1">注册时间</div>
      <div class="details-li2" v-if="users.regDate">{{users.regDate}}</div>
      <div class="details-li2" v-else>暂无</div>
      <div class="details-li3">最近在线</div>
      <div class="details-li4" v-if="users.lastOnlineTime">{{users.lastOnlineTime}}</div>
      <div class="details-li4" v-else>暂无</div>
    </div>
    <div class="details-ul">
      <div class="details-li1">登录次数</div>
      <div class="details-li2">{{users.loginTimes}}</div>
      <div class="details-li3">在线时长/小时</div>
      <div class="details-li4" v-if="users.onlineTime">{{Math.floor(users.onlineTime/3600 * 100) / 100 }} </div>
      <div class="details-li4" v-else>暂无</div>
    </div>
    <div class="details-ul">
      <div class="details-li1">书币余额</div>
      <div class="details-li2">{{users.bookMoney}}</div>
      <div class="details-li3">阅读时长/小时</div>
      <div class="details-li4" v-if="users.readingTime">{{Math.floor(users.readingTime/3600 * 100) / 100 }}</div>
      <div class="details-li4" v-else>暂无</div>
    </div>
    <div class="details-ul">
      <div class="details-li1">畅读卡</div>
      <div class="details-li2" v-if="users.userReadCardTime">到期时间：{{users.userReadCardTime}}</div>
      <div class="details-li2" v-else>暂无</div>
      <div class="details-li3">书架书籍</div>
      <div class="details-li4 bookshelf" v-if="users.bookshelf">
        <el-popover placement="bottom" trigger="click">
          <el-table :data="gridData" height="250" border>
            <el-table-column width="150" property="cBID" label="书籍ID" align="center"></el-table-column>
            <el-table-column width="150" property="title" label="书籍名称" align="center" :show-overflow-tooltip="true"></el-table-column>
            <el-table-column width="100" property="authorName" label="作者" align="center" :show-overflow-tooltip="true"></el-table-column>
            <!-- <el-table-column width="100" property="date" label="阅读进度" align="center"></el-table-column> -->
            <!-- <el-table-column width="100" property="name" label="添加时间" align="center"></el-table-column> -->
            <el-table-column width="100" property="address" label="操作" align="center">
              <template slot-scope="scope" align="center">
                <el-button type="text" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-button slot="reference" type="text" @click="bookleng">{{users.bookshelf.length}}本</el-button>
        </el-popover>
      </div>

      <div class="details-li4" v-else>暂无</div>
    </div>

    <div class="details-ul">
      <div class="details-li5">地理位置</div>
      <div class="details-li6">
        <div class="details-li6-f" v-if="users.address">
          {{BaiduMap(users.address.latitude,users.address.longitude)}} &nbsp;&nbsp;&nbsp;&nbsp; {{users.address.updateDate}}
        </div>
        <div class="details-li6-f" v-else>
          暂无地址
        </div>
        <div class="details-li6-r">
          <el-popover placement="bottom" width="500" trigger="click">
            <el-table :data="gridData">
              <el-table-column width="150" property="date" label="日期"></el-table-column>
              <el-table-column width="100" property="name" label="姓名"></el-table-column>
              <el-table-column width="250" property="address" label="地址"></el-table-column>
            </el-table>
            <el-button slot="reference" disabled>查看历史位置</el-button>
          </el-popover>
        </div>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li1">当前版本</div>
      <div class="details-li2" v-if="users.regVersion">{{users.regVersion}}</div>
      <div class="details-li2" v-else>暂无</div>
      <div class="details-li3">设备ID</div>
      <div class="details-li4">{{users.imei}}</div>
    </div>

    <div class="details-ul" v-if="users.userStatus == 'normal'">
      <div class="details-li5">用户状态</div>
      <div class="details-li6">
        <div class="details-li6-f">
          账户正常 | 设备正常
        </div>
        <div class="details-li6-r">
          <el-button size="mini" @click="fenghao">封号</el-button>
          <el-button size="mini" @click="fengshebei">封设备</el-button>
          <el-button size="mini" @click="zhuxiao">注销</el-button>
        </div>
      </div>
    </div>

    <div class="details-ul" v-else-if="users.userStatus == 'frozen'">
      <div class="details-li5">用户状态</div>
      <div class="details-li6">
        <div class="details-li6-f">
          账户异常 | 设备正常
        </div>
        <div class="details-li6-r">
          <el-button size="mini" @click="fenghao1">解封</el-button>
          <el-button size="mini" @click="fengshebei">封设备</el-button>
          <el-button size="mini" @click="zhuxiao">注销</el-button>
        </div>
      </div>
    </div>

    <div class="details-ul" v-else-if="users.userStatus == 'frozenByImei'">
      <div class="details-li5">用户状态</div>
      <div class="details-li6">
        <div class="details-li6-f">
          账户异常 | 设备异常
        </div>
        <div class="details-li6-r">
          <el-button size="mini" @click="fenghao" disabled>解封</el-button>
          <el-button size="mini" @click="fengshebei1">解封设备</el-button>
          <el-button size="mini" @click="zhuxiao" disabled>注销</el-button>
        </div>
      </div>
    </div>

    <div class="details-ul" v-else-if="users.userStatus == 'drawdown'">
      <div class="details-li5">用户状态</div>
      <div class="details-li6">
        <div class="details-li6-f">
          已注销 | 设备正常
        </div>
        <div class="details-li6-r">
          <el-button size="mini" @click="fenghao" disabled>封号</el-button>
          <el-button size="mini" @click="fengshebei" disabled>封设备</el-button>
          <el-button size="mini" @click="zhuxiao" disabled>已注销</el-button>
        </div>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li5-img">用户头像</div>
      <div class="details-li6-img">
        <img :src="users.avatar" alt="">
        <el-button size="mini" @click="shanchu">删除</el-button>
      </div>
    </div>
    <div class="details-ul">
      <div class="details-li-but">
        <!-- <el-button size="mini" @click="zhifu">用户支付记录</el-button> -->
        <el-button size="mini" @click="zhifu">用户支付记录</el-button>
        <el-button size="mini" @click="xiaofei">用户消费记录</el-button>
        <el-button size="mini" @click="yuedu">用户阅读记录</el-button>
        <el-button size="mini" @click="tuisong">推送用户消息</el-button>
      </div>
    </div>
  </div>
</template>


<script>
import {
  customeruserInfoDetail,
  customerupdateCustomerStatus,
  customerupdateCustomerInfo,
  customerbookshelfList,
  customerdeleteBookAtBookshelf,
  customerupdateCustomerBindPhone
} from "@/apis/api";
import { Utils, Dates } from "@/apis/mUtils";
import { mapState, mapMutations } from "vuex";
export default {
  props: ["uid"],
  data() {
    return {
      //具体列表
      users: {
        address: {
          createDate: "",
          latitude: "",
          longitude: "",
          uid: "",
          updateDate: ""
        },
        avatar: "",
        bindPhone: "",
        bookMoney: "",
        bookshelf: "",
        curAppVersion: "",
        imei: "",
        lastOnlineTime: "",
        loginTimes: "",
        name: "",
        onlineTime: "",
        phoneModel: "",
        readingTime: "",
        regDate: "",
        sex: "",
        uid: "",
        userReadCardTime: "",
        userStatus: ""
      },
      gridData: [],
      mapaddComp: ""
    };
  },
  methods: {
    //书架删除
    handleDelete(index, row){
       this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let para ={
        uid: this.users.uid,
        cBID : row.cBID
      }
      customerdeleteBookAtBookshelf(para).then(res=>{
         if (res.data.result !== "success") {
          this.$message.error(`失败`);
          return false;
        }
         this.Userlist();
         this.bookleng();
         this.$message.success(`删除成功`);
      })
      });
      
    },
    //书架
    bookleng() {
      let para={
        uid: this.users.uid
      }
      customerbookshelfList(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取失败`);
          return false;
        }
        this.gridData = res.data.data;
        console.log(this.gridData)
      });
    },
    BaiduMap(a, b) {
      var reg = /^[0-9]+.?[0-9]*$/;
      if (!reg.test(a)) return "暂未定位";
      let point = new BMap.Point(a, b);
      let geoc = new BMap.Geocoder();
      geoc.getLocation(point, rs => {
        this.mapaddComp = rs.address;
      });
      return this.mapaddComp;
    },
    ...mapMutations([
      "changezhifu",
      "changexiaofei",
      "changeBook",
      "changetuisong"
    ]),
    tuisong() {
      let para = {
        tuisong: "second",
        uid: this.users.uid
      };
      this.$emit("hiden");
      this.changetuisong(para);
      this.$router.push("/Push");
    },
    yuedu() {
      let para = {
        book: "second",
        uid: this.users.uid
      };
      this.$emit("hiden");
      this.changeBook(para);
      this.$router.push("/books");
    },

    zhifu() {
      this.$emit("hiden");
      this.changezhifu(this.users.uid);
      this.$router.push("/Order");
    },

    xiaofei() {
       this.$emit("hiden");
      this.changexiaofei(this.users.uid);
      this.$router.push("/Bookcurrency");
    },
    nicheng() {
      this.$prompt("", "修改用户昵称", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputPlaceholder: "请输入昵称",
        center: true,
        inputPattern: /\S/,
        inputErrorMessage: "昵称不能为空"
      })
        .then(({ value }) => {
          let para = {
            uid: this.users.uid,
            name: value
          };
          customerupdateCustomerInfo(para).then(res => {
            if (res.data.result !== "success") {
              this.$message.error(`修改昵称失败`);
              return false;
            }
            this.Userlist();
            this.$message({
              type: "success",
              message: "修改昵称成功!"
            });
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    haoma() {
      this.$prompt("", "修改绑定手机", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputPlaceholder: "输入修改手机号码",
        center: true,
        inputPattern: /^1(3|4|5|7|8)\d{9}$/,
        inputErrorMessage: "手机号码有误，请重填"
      })
        .then(({ value }) => {
          let para = {
            uid: this.users.uid,
            bindPhone: value
          };
          customerupdateCustomerBindPhone(para).then(res => {
            if (res.data.result !== "success") {
              this.$message.error(res.data.msg);
              return false;
            }
            this.Userlist();
            this.$message({
              type: "success",
              message: "修改手机号成功!"
            });
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },

    shanchu() {
      this.$confirm("是否删除该图片？", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        center: true
      }).then(() => {
        let para = {
          uid: this.users.uid,
          avatar: "http://qy-pic.oss-cn-shenzhen.aliyuncs.com/head/default.png"
        };
        customerupdateCustomerInfo(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`修改失败`);
            return false;
          }
          this.Userlist();
          this.$message({
            type: "success",
            message: "修改成功!"
          });
        });
      });
    },

    fenghao(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 50px; line-height: 50px;">是否<span style=" color: red;">冻结</span>该账号？<p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          uid: this.users.uid,
          customerStatus: "frozen"
        };
        customerupdateCustomerStatus(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`冻结失败`);
            return false;
          }
          this.Userlist();
          this.$message({
            type: "success",
            message: "冻结成功!"
          });
        });
      });
    },

    fenghao1(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 50px; line-height: 50px;">是否<span style=" color: red;">解冻</span>该账号？<p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          uid: this.users.uid,
          customerStatus: "unFrozen"
        };
        customerupdateCustomerStatus(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`解冻失败`);
            return false;
          }
          this.Userlist();
          this.$message({
            type: "success",
            message: "解冻成功!"
          });
        });
      });
    },

    fengshebei(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 100px; line-height: 50px;">是否<span style=" color: red;">冻结</span>该账户并<br><span style=" color: red;">封禁设备</span><p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          uid: this.users.uid,
          customerStatus: "frozenByImei"
        };
        customerupdateCustomerStatus(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`封禁设备失败`);
            return false;
          }
          this.Userlist();
          this.$message({
            type: "success",
            message: "封禁设备成功!"
          });
        });
      });
    },

    fengshebei1(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 100px; line-height: 50px;">是否<span style=" color: red;">解冻</span>该账户并<br><span style=" color: red;">解封设备</span><p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          uid: this.users.uid,
          customerStatus: "unFrozenByImei"
        };
        customerupdateCustomerStatus(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`解封设备失败`);
            return false;
          }
          this.Userlist();
          this.$message({
            type: "success",
            message: "解封设备成功!"
          });
        });
      });
    },

    zhuxiao(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 50px; line-height: 50px;">是否<span style=" color: red;">注销</span>该账号？<p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          uid: this.users.uid,
          customerStatus: "drawdown"
        };
        customerupdateCustomerStatus(para).then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`注销失败`);
            return false;
          }
          this.Userlist();
          this.$message({
            type: "success",
            message: "注销成功!"
          });
        });
      });
    },

    // 获取用户列表：
    Userlist() {
      let para = {
        uid: this.uid
      };
      customeruserInfoDetail(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取失败`);
          return false;
        }
        this.users = res.data.data;
        console.log(res.data);
      });
    }
  },

  watch: {
    uid(e) {
      this.Userlist();
    }
  },

  // 获取用户数据
  mounted() {
    this.Userlist();
  }
};
</script>


<style lang="less" scoped>
.details {
  border: #ccc 1px solid;
  .details-ul {
    display: flex;
    border-bottom: #ccc 1px solid;
    & > div {
      height: 50px;
      display: flex;
      justify-content: center;
      align-items: center;
      border-right: #ccc 1px solid;
    }
    .details-li-but {
      height: 80px;
      width: 100%;
      button {
        margin: 0 20px;
      }
    }
    .details-li1 {
      flex: 1;
    }
    .details-li2 {
      flex: 3;
    }
    .details-li3 {
      flex: 3;
    }
    .details-li4 {
      flex: 5;
      span {
        padding: 0 40px;
      }
    }
    .details-li5 {
      flex: 1;
    }
    .details-li6 {
      flex: 11;
      display: flex;
      justify-content: space-around;
    }
    .details-li5-img {
      flex: 1;
      height: 120px;
    }
    .details-li6-img {
      flex: 11;
      height: 120px;
      img {
        width: 100px;
        padding: 0 30px;
      }
    }
  }
}
</style>
