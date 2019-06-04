<template>
  <div class="box">

    <el-card shadow="hover" class="mgb20" style="height:252px;">
      <div class="user-info">
        <img src="static/img/img.jpg" class="user-avator" alt="">
        <div class="user-info-cont">
          <div class="user-info-name">{{name}}</div>
          <div>{{role}}</div>
        </div>
      </div>
      <div class="user-info-list">上次登录时间：<span>{{names.lastLoginTime}}</span></div>
      <div class="user-info-list">上次登录IP：<span>{{names.lastLoginIp}}</span></div>
    </el-card>

    
  </div>
</template>

<script>
import bus from "./common/bus";
import { channellist } from "@/apis/api";
import { setStore, getStore, removeStore } from "@/apis/mUtils";
export default {
  name: "dashboard",
  data() {
    return {
      name: getStore("ms_username"),
      names: JSON.parse(getStore("username")|| "[]"),
      data: [
        {
          name: "2018/09/04",
          value: 1083
        },
        {
          name: "2018/09/05",
          value: 941
        },
        {
          name: "2018/09/06",
          value: 1139
        },
        {
          name: "2018/09/07",
          value: 816
        },
        {
          name: "2018/09/08",
          value: 327
        },
        {
          name: "2018/09/09",
          value: 228
        },
        {
          name: "2018/09/10",
          value: 1065
        }
      ]
    };
  },
  computed: {
    role() {
      return getStore("ms_username") == "admin" ? "管理员" : "系统用户";
    }
  },
  created() {
    this.changeDate();
    this.rolelist()
  },
  activated() {},

  methods: {
    changeDate() {
      const now = new Date().getTime();
      this.data.forEach((item, index) => {
        const date = new Date(now - (6 - index) * 86400000);
        item.name = `${date.getFullYear()}/${date.getMonth() +
          1}/${date.getDate()}`;
      });
    },
    rolelist() {
      channellist().then (res=>{
       if (res.data.result !== "success") {
          return false;
        }
        setStore("role", res.data.data);
      })
    }
  }
};
</script>


<style scoped>
.box {
  width: 500px;
}
.el-row {
  margin-bottom: 20px;
}

.grid-content {
  display: flex;
  align-items: center;
  height: 100px;
}

.grid-cont-right {
  flex: 1;
  text-align: center;
  font-size: 14px;
  color: #999;
}

.grid-num {
  font-size: 30px;
  font-weight: bold;
}

.grid-con-icon {
  font-size: 50px;
  width: 100px;
  height: 100px;
  text-align: center;
  line-height: 100px;
  color: #fff;
}

.grid-con-1 .grid-con-icon {
  background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
  color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
  background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
  color: rgb(45, 140, 240);
}

.grid-con-3 .grid-con-icon {
  background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
  color: rgb(242, 94, 67);
}

.user-info {
  display: flex;
  align-items: center;
  padding-bottom: 20px;
  border-bottom: 2px solid #ccc;
  margin-bottom: 20px;
}

.user-avator {
  width: 120px;
  height: 120px;
  border-radius: 50%;
}

.user-info-cont {
  padding-left: 50px;
  flex: 1;
  font-size: 14px;
  color: #999;
}

.user-info-cont div:first-child {
  font-size: 30px;
  color: #222;
}

.user-info-list {
  font-size: 14px;
  color: #999;
  line-height: 25px;
}

.user-info-list span {
  margin-left: 70px;
}

.mgb20 {
  margin-bottom: 20px;
}

.todo-item {
  font-size: 14px;
}

.todo-item-del {
  text-decoration: line-through;
  color: #999;
}
</style>
