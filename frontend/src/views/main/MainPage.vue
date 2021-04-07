<template>
  <div>
    <!-- 차량 분석 컴포넌트 -->
    <CarSearchResult
      id="carSearchResult"
      :modelInfo="modelInfo.modelDetailList[0]"
    />
    <!-- 차량 시세 차트 -->
    <CarPrice :allOptions="allOptions" :mdName="md_name" class="chart" />
    <!-- 차량 비교 차트 -->
    <CarCompare
      :latestModel="latestModel"
      :modelInfo="modelInfo.modelDetailList[0]"
    />
    <!-- 차량 모델비교(가격) -->
    <a class="pushme"> <span class="inner">모델비교</span></a>
    <div class="model-title">#가격대가 비슷한 모델</div>
    <CarModel :CompareCars="similarPriceCar" />
    <!-- 차량 모델비교(차체크기) -->
    <div class="model-title">#차종이 비슷한 모델</div>
    <CarModel :CompareCars="sameSegmentCar" />
    <!-- 차량 뉴스 -->
    <CarNews
      id="carNewsInfo"
      :defaultNewsData="carDefaultNews"
      :addNewsData="carAddNews"
      :CarModelName="m_name"
    />
    <!-- :newsData="carNews"  -->
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
import store from "@/store/index";
import CarCompare from "@/components/carInfo/CarCompare.vue";
import {
  // fetchModel,
  fetchAllOptions,
  fetchLatest,
  fetchPriceCompare,
  fetchSizeCompare,
  fetchNews,
  fetchShops
} from "@/api/index";
import bus from "@/utils/bus";

export default Vue.extend({
  props: {
    modelInfo: {
      type: Object,
      default:
        // JSON.parse(window.sessionStorage.getItem("model-info")) ||
        store.state.modelInfo || null
    },
    reload: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      m_id: Number,
      md_id: Number,
      m_name: String,
      md_name: this.$store.state.modelName || "",
      allOptions: (this.modelInfo.modelDetailList[0].optionList as any) || null,
      latestModel: this.$store.state.latestModel || null,
      similarPriceCar: this.$store.state.similarModel || {},
      sameSegmentCar: this.$store.state.sameSegment || {},
      // carNews: Array,
      carDefaultNews: Array,
      carAddNews: Array,
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
    this.goReload();
    this.getModelInfo();
    // this.getCarAllOptions();
  },
  methods: {
    goReload() {
      if (this.$route.params.reload) {
        bus.$emit("on:progress");
        window.location.reload();
        window.scrollTo(0, 0);
      }
    },
    getModelInfo() {
      // const { data } = await fetchModel(this.m_id);
      console.log("this.modelInfo : ", this.modelInfo);
      this.m_id = this.modelInfo.id;
      this.md_id = this.modelInfo.modelDetailList[0].id;
      this.m_name = this.modelInfo.name;
      this.md_name = this.modelInfo.modelDetailList[0].name;
      this.allOptions = this.modelInfo.modelDetailList[0].optionList;
      console.log(this.m_id, this.md_id);
      // this.getLatestModel();
      this.getSimilarPriceModel();
      this.getSameSegmentModel();
      this.getCarNews();
      this.getCarGoods();
    },
    async getCarAllOptions() {
      const { data } = await fetchAllOptions(
        this.modelInfo.modelDetailList[0].id
      );
      this.allOptions = data;
    },
    async getLatestModel() {
      const { data } = await fetchLatest(this.modelInfo.id);
      this.latestModel = data;
      console.log("latestModel : ", this.latestModel);
    },
    async getSimilarPriceModel() {
      const { data } = await fetchPriceCompare(this.modelInfo.id);
      this.similarPriceCar = data;
      console.log("similarPriceCar : ", this.similarPriceCar);
    },
    async getSameSegmentModel() {
      const { data } = await fetchSizeCompare(this.modelInfo.id);
      this.sameSegmentCar = data;
      console.log("sameSegmentCar : ", this.sameSegmentCar);
    },
    async getCarNews() {
      const { data } = await fetchNews(this.modelInfo.name);
      const dList = [];
      const aList = [];
      for (let i = 0; i < data.length; i++) {
        if (i < 2) {
          dList.push(data[i]);
        } else {
          aList.push(data[i]);
        }
      }
      // this.carNews = data;
      // console.log("carNews : ", this.carNews);
      this.carDefaultNews = dList;
      this.carAddNews = aList;
    },
    async getCarGoods() {
      const { data } = await fetchShops(this.modelInfo.name);
      this.carGoods = data;
      console.log("carGoods : ", this.carGoods);
      bus.$emit("off:progress");
    }
  }
});
</script>

<style></style>
