<template>
  <div class="tags">
    <p>{{title}} </p>
  </div>
</template>

<script>
import bus from "./bus";
import { setStore, getStore, removeStore } from "@/apis/mUtils";
export default {
  data() {
    return {
      title: ""
    };
  },
  methods: {
    // 设置标签
    setTags(route) {
      this.title = route.meta.title || getStore('metaTitle');
    }
  },
  computed: {},
  watch: {
    $route(newValue, oldValue) {
      this.setTags(newValue);
    }
  },
  created() {
    // console.log(this.$route)
    this.setTags(this.$route);
  }
};
</script>


<style lang="less" scoped>
.tags {
  height: 60px;
  line-height: 60px;
  border-bottom: #c2c4ce 2px solid;
}
p {
  font-size: 20px;
  font-weight: 600;
  color: #999999;
}
</style>

