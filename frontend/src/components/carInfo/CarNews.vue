<template>
  <div>
    <h1>{{ CarModelName }}의 최신 정보를 확인해보세요</h1>
    <CarNewsItem :NewsTitle="NewsTitle" :NewsContext="NewsContext" />
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { fetchNews } from "@/api/index";
import CarNewsItem from "@/components/carInfo/CarNewsItem.vue";

export default Vue.extend({
  components: { CarNewsItem },
  props: {
    CarModelName: {
      type: String,
      default: "grandeur"
    }
  },
  data() {
    return {
      news: {}
    };
  },
  created() {
    this.getNews();
  },
  methods: {
    async getNews() {
      const response = await fetchNews(this.CarModelName);
      this.news = response.data;
    }
  }
});
</script>

<style></style>
