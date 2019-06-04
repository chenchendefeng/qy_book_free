<template>
  <div class="wrapper">
    <v-head></v-head>
    <v-sidebar></v-sidebar>
    <div class="content-box" :class="{'content-collapse':collapse}">
      <v-tags></v-tags>
      <div class="content">
        <transition name="move" mode="out-in">
          <!-- <keep-alive :include="tagsList"> -->
          <router-view></router-view>
          <!-- </keep-alive> -->
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
import vHead from "./Header.vue";
import vSidebar from "./Sidebar.vue";
import vTags from "./Tags.vue";
import bus from "./bus";
export default {
  data() {
    return {
      tagsList: [],
      collapse: false
    };
  },
  components: {
    vHead,
    vSidebar,
    vTags
  },
  created() {
    bus.$on("collapse", msg => {
      // console.log(msg)
      this.collapse = msg;
    });
  }
};
</script>

<style>
.wrapper {
  background: #eee;
}
.content-box {
  min-width: 950px;
  
}
.content {
  min-width: 950px;
}
</style>

