<template>
  <div class="news">
    {{ NewsTitle }}
    {{ NewsContext }}
  </div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  props: {
    NewsTitle : {
      type : String,
      default : "뉴스 타이틀"
    },
    NewsContext : {
      type : String,
      default : "뉴스 내용"
    }
  }

});
</script>

<style></style>
