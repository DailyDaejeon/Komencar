<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult />
    <!-- 차량 시세 차트 -->
    <CarPrice />
    <!-- 차량 뉴스 -->
    <CarNews />
    <!-- 차량 굿즈 -->
    <CarGoods />
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarSearchResult from "@/components/carSearch/CarSearchResult.vue";
import CarNews from "@/components/carInfo/CarNews.vue";
import CarGoods from "@/components/carInfo/CarGoods.vue";
import CarPrice from "@/components/carInfo/CarPrice.vue";

export default Vue.extend({
  components: { CarSearchResult, CarNews, CarGoods, CarPrice }
});
</script>

<style></style>
