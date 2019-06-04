<template>
  <div class="sidebar">
    <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#f4f4f4" text-color="#474747" active-text-color="#20a0ff" unique-opened router>
      <template v-for="item in list">
        <template v-if="item.kids">
          <el-submenu :index="item.rightName" :key="item.id">
            <template slot="title">
              <i class="el-icon-menu"></i><span slot="title">{{ item.rightName }}</span>
            </template>
            <template v-for="subItem in item.kids">
              <el-menu-item :index="subItem.url" :key="subItem.id">
                {{ subItem.rightName }}
              </el-menu-item>
            </template>
          </el-submenu>
        </template>
      </template>
    </el-menu>

  </div>
</template>

<script>
import bus from "../common/bus";
import { setStore, getStore, removeStore, Utils } from "@/apis/mUtils";
import { requestLogin, requestlogout } from "@/apis/api";
export default {
  data() {
    return {
      collapse: false,
      list: [],
      lists: JSON.parse(getStore("permissions") || "[]")
    };
  },
  mounted() {
    let para = [];
    this.lists.forEach(item => {
      if (item.parentId == 0) {
        para.push(item);
      }
    });
    this.list = para;
  },
  computed: {
    onRoutes() {
      return this.$route.path;
    }
  },
  created() {
    // 通过 Event Bus 进行组件间通信，来折叠侧边栏
    bus.$on("collapse", msg => {
      this.collapse = msg;
    });
  }
};
</script>

<style scoped>
.sidebar {
  display: block;
  position: absolute;
  left: 10px;
  top: 80px;
  bottom: 0;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
  width: 200px;
}
.sidebar > ul {
  height: 100%;
}
</style>
