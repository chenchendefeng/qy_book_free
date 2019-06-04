<template>
  <div class="push">
    <el-tabs :value="activeName" @tab-click="handleClick">
      <el-tab-pane label="群发推送" name="first">
        <group-chat></group-chat>
      </el-tab-pane>
      <el-tab-pane label="单聊推送" name="second">
        <single-chat></single-chat>
      </el-tab-pane>
      <el-tab-pane label="推送记录" name="third">
        <push-list ref="third"></push-list>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import groupChat from "@/components/push/groupChat";
import pushList from "@/components/push/pushList";
import singleChat from "@/components/push/singleChat";
import { mapState, mapMutations } from "vuex";
export default {
  components: {
    groupChat,
    pushList,
    singleChat
  },
  data() {
    return {};
  },
  computed: {
    activeName() {
      return this.$store.state.tuisong;
    }
  },
  methods: {
    ...mapMutations(["changetuisong", "rmove"]),
    handleClick(tab, event) {
      let para = {
        tuisong: tab.name,
        uid: ""
      };
      this.changetuisong(para);
      if(tab.name === 'third'){
        this.$refs.third.fetchData()
      }
    }
  },
  watch: {
    activeName(e) {
      // console.log(e);
    }
  }
};
</script>

<style lang="less" scoped>
.push {
  .el-tabs__item.is-active {
    color: red;
  }
}
</style>
