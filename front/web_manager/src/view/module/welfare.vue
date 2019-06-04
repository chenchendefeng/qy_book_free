<template>
  <section class="welfare">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="新人福利" name="novice">
        <welfareList type="novice" />
      </el-tab-pane>
      <el-tab-pane label="阅读福利" name="read">
        <welfareList type="read" />
      </el-tab-pane>
      <el-tab-pane label="日常福利" name="daily">
        <welfareList type="daily" />
      </el-tab-pane>
    </el-tabs>
  </section>
</template>
<script>
import welfareList from "@/components/module/welfareList.vue";
export default {
  components: {
    welfareList
  },
  data() {
    return {
      activeName: this.$route.params.type || "novice"
    };
  },
  methods: {
    handleClick(tab, event) {
      this.$router.push(`/module/welfare/${tab.name}`)
    }
  }
};
</script>
