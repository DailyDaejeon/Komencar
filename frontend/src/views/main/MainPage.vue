<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult :modelInfo="modelInfo" />
    <!-- 차량 시세 차트 -->
    <CarPrice :allOptions="allOptions" />
    <!-- 차량 비교 차트 -->
    <CarCompare :latestModel="latestModel" :modelInfo="modelInfo" />
    <!-- 차량 모델비교(가격) -->
    <CarModel :CompareCar="similarPriceCar" />
    <!-- 차량 모델비교(차체크기) -->
    <CarModel :CompareCar="sameSegmentCar" />
    <!-- 차량 뉴스 -->
    <CarNews :carNews="carNews" />
    <!-- 차량 댓글 비교(텍스트마이닝 된다면) -->
    <!-- <CarReview/> -->
    <!-- 차량 굿즈 -->
    <CarGoods :carGoods="carGoods" />
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
import {
  fetchModel,
  fetchAllOptions,
  fetchLatest,
  fetchPriceCompare,
  fetchSizeCompare,
  fetchNews,
  fetchShops
} from "@/api/index";

export default Vue.extend({
  props: {
    m_id: {
      type: Number,
      default: 0
    },
    md_id: {
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
      modelInfo: Object,
      allOptions: Array,
      latestModel: Object,
      similarPriceCar: Object,
      sameSegmentCar: Object,
      carNews: Array,
      carGoods: Array
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
    this.getModelInfo();
    this.getCarAllOptions();
    this.getLatestModel();
    this.getSimilarPriceModel();
    this.getSameSegmentModel();
    this.getCarNews();
    this.getCarGoods();
  },
  methods: {
    async getModelInfo() {
      const { data } = await fetchModel(this.m_id);
      this.modelInfo = data;
    },
    async getCarAllOptions() {
      const { data } = await fetchAllOptions(this.m_id);
      this.allOptions = data;
    },
    async getLatestModel() {
      const { data } = await fetchLatest(this.m_id);
      this.latestModel = data;
    },
    async getSimilarPriceModel() {
      const { data } = await fetchPriceCompare(this.m_id);
      this.similarPriceCar = data;
    },
    async getSameSegmentModel() {
      const { data } = await fetchSizeCompare(this.m_id);
      this.sameSegmentCar = data;
    },
    async getCarNews() {
      const { data } = await fetchNews(this.m_name);
      this.carNews = data;
    },
    async getCarGoods() {
      const { data } = await fetchShops(this.m_name);
      this.carGoods = data;
    }
  }
});
</script>

<style></style>
