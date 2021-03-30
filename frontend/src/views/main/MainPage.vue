<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult />
    <!-- 차량 시세 차트 -->
    <CarPrice :MaxCarPrice="MaxCarPrice" :MinCarPrice="MinCarPrice" />
    <!-- 차량 뉴스 -->
    <CarNews :CarModelName="CarModelName" />
    <!-- 차량 모델비교 -->
    <CarModel />
    <!-- 차량 댓글 비교(텍스트마이닝 된다면) -->
    <!-- <CarReview/> -->
    <!-- 차량 굿즈 -->
    <CarGoods :CarModelName="CarModelName" />
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarSearchResult from "@/components/carSearch/CarSearchResult.vue";
import CarNews from "@/components/carInfo/CarNews.vue";
import CarGoods from "@/components/carInfo/CarGoods.vue";
import CarPrice from "@/components/carInfo/CarPrice.vue";
import CarModel from "@/components/carInfo/CarModel.vue";

export default Vue.extend({
  components: { CarSearchResult, CarNews, CarGoods, CarPrice, CarModel }
});
</script>

<style></style>
