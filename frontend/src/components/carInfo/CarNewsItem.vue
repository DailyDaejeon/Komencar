<template>
  <div class="newsItem">
    <div class="newsItem__title">{{ news.title }}</div>
    <div class="newsItem__desc">{{ news.description }}</div>
    <a :href="this.news.link" class="newsItem__more">원문보기</a>
  </div>
</template>

<script lang="ts">

import Vue from "vue";
export default Vue.extend({
  props: {
    news: {
      type: Object
    }
  }
  // methods: {
  //   goNewsLink() {
  //   //   const newsLink = this.news.link;

  //   // }
  // }
});
</script>

<style></style>
