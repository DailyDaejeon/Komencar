<template>
  <div class="newsItem" ref="newsItem">
    <div class="newsItem__title" v-html="news.title"></div>
    <div class="newsItem__desc" v-html="description"></div> <!-- {{ news.description }} -->
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
  created() {
    this.handleResize();
  },
  mounted() {
    window.addEventListener('resize', this.handleResize);
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.handleResize);
  },
  methods: {
  //   goNewsLink() {
  //   //   const newsLink = this.news.link;

  //   // }
    // setDescription(){
    //   this.description = this.news.description;

    //   if(this.description.length >  )
    // }
    handleResize(event) {
        // this.width = window.innerWidth;
        this.width = this.$refs.newsItem.innerWidth;
        console.log("this is width : ",this.width);
        if(this.width < 300){
          this.description = this.news.description.substr(0,30)+"...";
        } else if(this.width > 300 && this.width < 600){  //모바일 기기
          this.description = this.news.description.substr(0,66)+"...";
        } else if(this.width > 600 && this.width < 1080) { //태블릿 기기
          this.title = this.news.title;
          this.description = this.news.description.substr(0,120)+"...";
        } else if(this.width > 1080) { //웹 화면
          this.description = this.news.description;
        }
    }
  }
});
</script>

<style></style>
