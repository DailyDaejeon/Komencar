<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult
      id="carSearchResult"
      :modelInfo="modelInfo.modelDetailList[0]"
    />
    <!-- 차량 시세 차트 -->
    <CarPrice :allOptions="allOptions" :mdName="md_name" />
    <!-- 차량 비교 차트 -->
    <!-- <CarCompare
      :latestModel="latestModel"
      :modelInfo="modelInfo.modelDetailList[0]"
    /> -->
    <!-- 차량 모델비교(가격) -->
    <h1 id="carCompare">동급모델</h1>
    <div class="model-title">#가격</div>
    <CarModel :CompareCar="similarPriceCar" />
    <!-- 차량 모델비교(차체크기) -->
    <div class="model-title">#크기</div>
    <CarModel :CompareCar="sameSegmentCar" />
    <!-- 차량 뉴스 -->
    <CarNews :newsData="carNews" id="carNewsInfo" :CarModelName="m_name" />
    <!-- 차량 굿즈 -->
    <CarGoods id="carGoodsInfo" :goodsData="carGoods" :CarModelName="m_name" />
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarSearchResult from "@/components/carSearch/CarSearchResult.vue";
import CarNews from "@/components/carInfo/CarNews.vue";
import CarGoods from "@/components/carInfo/CarGoods.vue";
import CarPrice from "@/components/carInfo/CarPrice.vue";
import CarModel from "@/components/carInfo/CarModel.vue";
// import CarCompare from "@/components/carInfo/CarCompare.vue";
import {
  // fetchModel,
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
      m_id: Number,
      md_id: Number,
      m_name: String,
      md_name: String,
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
    CarModel
    // CarCompare
  },
  created() {
    this.getModelInfo();
    // this.getCarAllOptions();
  },
  methods: {
    getModelInfo() {
      // const { data } = await fetchModel(this.m_id);
      // this.modelInfo = data;
      console.log("this.modelInfo : ", this.modelInfo);
      this.m_id = this.modelInfo.id;
      this.md_id = this.modelInfo.modelDetailList[0].id;
      this.m_name = this.modelInfo.name;
      this.md_name = this.modelInfo.modelDetailList[0].name;
      this.allOptions = this.modelInfo.modelDetailList[0].optionList;
      // this.getLatestModel();
      this.getSimilarPriceModel();
      this.getSameSegmentModel();
      this.getCarNews();
      this.getCarGoods();
    },
    async getCarAllOptions() {
      const { data } = await fetchAllOptions(this.md_id);
      this.allOptions = data;
    },
    async getLatestModel() {
      const { data } = await fetchLatest(this.m_id);
      this.latestModel = data;
      console.log("latestModel : ", this.latestModel);
    },
    async getSimilarPriceModel() {
      const { data } = await fetchPriceCompare(this.m_id);
      this.similarPriceCar = data;
      console.log("similarPriceCar : ", this.similarPriceCar);
    },
    async getSameSegmentModel() {
      const { data } = await fetchSizeCompare(this.m_id);
      this.sameSegmentCar = data;
      console.log("sameSegmentCar : ", this.sameSegmentCar);
    },
    async getCarNews() {
      const { data } = await fetchNews(this.m_name);
      this.carNews = data;
      console.log("carNews : ", this.carNews);
    },
    async getCarGoods() {
      const { data } = await fetchShops(this.m_name);
      this.carGoods = data;
      console.log("carGoods : ", this.carGoods);
    }
  }
});
</script>

<style></style>
