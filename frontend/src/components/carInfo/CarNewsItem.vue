<template>
  <div class="newsItem" id="newsItem">
    <div class="newsItem__title" v-html="news.title"></div>
    <div class="newsItem__desc" v-html="description"></div>
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
  },
  data() {
    return {
      title: String,
      description: String,
      width: 0,
    }
  },
  mounted() {
    this.handleResize();
    window.addEventListener('resize', this.handleResize);
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.handleResize);
  },
  methods: {
    handleResize() {
      this.width = document.getElementById('newsItem').clientWidth;
      
      if(this.width < 185){
        this.description = this.news.description.substr(0,30)+"...";
      } //모바일 기기1
      else if(this.width > 300 && this.width < 600){
        this.description = this.news.description.substr(0,66)+"...";
      } //모바일 기기2
      else if(this.width > 600 && this.width < 1080) {
        this.title = this.news.title;
        this.description = this.news.description.substr(0,120)+"...";
      } //태블릿 기기
      else if(this.width > 1080) {
        this.description = this.news.description;
      } //웹 화면
    }
  }
});
</script>

<style></style>
