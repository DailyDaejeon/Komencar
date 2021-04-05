<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult id="carSearchResult" :modelInfo="modelInfo" />
    <!-- 차량 시세 차트 -->
    <CarPrice :allOptions="allOptions" :mdName="m_name" />
    <!-- 차량 비교 차트 -->
    <CarCompare :latestModel="latestModel" :modelInfo="modelInfo" />
    <!-- 차량 모델비교(가격) -->
    <h1 id="carCompare">동급모델</h1>
    <div class="model-title">#가격</div>
    <CarModel :CompareCar="similarPriceCar" />
    <!-- 차량 모델비교(차체크기) -->
    <div class="model-title">#크기</div>
    <CarModel :CompareCar="sameSegmentCar" />
    <!-- 차량 뉴스 -->
    <CarNews :newsData="carNews" id="carNewsInfo" />
    <!-- 차량 굿즈 -->
    <CarGoods id="carGoodsInfo" :goodsData="carGoods" />
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
    modelInfo: {
      type: Object
    }
  },
  data() {
    return {
      m_id: 1 as number,
      md_id: Number,
      m_name: String,
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
    // this.getCarAllOptions();
    this.getLatestModel();
    this.getSimilarPriceModel();
    this.getSameSegmentModel();
    this.getCarNews();
    this.getCarGoods();
  },
  methods: {
    async getModelInfo() {
      // const { data } = await fetchModel(this.m_id);
      // this.modelInfo = data;
      console.log("this.modelInfo : ", this.modelInfo);
      this.md_id = this.modelInfo.id;
      this.m_name = this.modelInfo.name;
      this.allOptions = this.modelInfo.optionList;
    },
    async getCarAllOptions() {
      const { data } = await fetchAllOptions(this.md_id);
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
