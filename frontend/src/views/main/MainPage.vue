<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult />
    <!-- 차량 시세 차트 -->
    <CarPrice />
    <!-- 차량 비교 차트 -->
    <CarCompare />
    <!-- 차량 모델비교(가격) -->
    <CarModel :CompareCar="similarPriceCar" />
    <!-- 차량 모델비교(차체크기) -->
    <CarModel :CompareCar="sameSegmentCar" />
    <!-- 차량 뉴스 -->
    <CarNews />
    <!-- 차량 댓글 비교(텍스트마이닝 된다면) -->
    <!-- <CarReview/> -->
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
import CarModel from "@/components/carInfo/CarModel.vue";
import CarCompare from "@/components/carInfo/CarCompare.vue";
import { fetchPriceCompare, fetchSizeCompare } from "@/api/index";

export default Vue.extend({
  props: {
    m_id: {
      type: Number,
      default: 0
    },
    m_name: {
      type: String,
      default: "grandeur"
    }
  },
  data() {
    return {
      similarPriceCar: {},
      sameSegmentCar: {}
    };
  },
  components: {
    CarSearchResult,
    CarNews,
    CarGoods,
    CarPrice,
    CarModel,
    CarCompare
  },
  created() {
    this.getSimilarPriceModel();
    this.getSameSegmentModel();
  },
  methods: {
    async getSimilarPriceModel() {
      const response = await fetchPriceCompare(this.m_id);
      this.similarPriceCar = response.data;
    },
    async getSameSegmentModel() {
      const response = await fetchSizeCompare(this.m_id);
      this.sameSegmentCar = response.data;
    }
  }
});
</script>

<style></style>
