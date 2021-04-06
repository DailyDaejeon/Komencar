<template>
  <div class="box">
    <div class="box__title">NEWS</div>
    <div class="box__subtitle">
      {{ CarModelName }}의 최신 정보를 확인해보세요
    </div>
    <div v-for="(news, index) in defaultNewsData" :key="index">
      <CarNewsItem :news="news" />
    </div>
    <div class="box__addButtonBox" @click="addNews" v-if="isShowButton">
      <div class="box__addButton">더보기</div>
    </div>
    <div v-if="!isShowButton">
      <div v-for="(news, index) in addNewsData" :key="index">
        <CarNewsItem :news="news" />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarNewsItem from "@/components/carInfo/CarNewsItem.vue";

export default Vue.extend({
  components: { CarNewsItem },
  props: {
    // newsData: {
    //   type: Array
    // },
    defaultNewsData: {
      type: Array
    },
    addNewsData: {
      type: Array
    },
    CarModelName: {
      type: String
    }
  },
  data() {
    return {
      // newsData: [
      //   {
      //     title: "현대차 7세대 그랜저, 2022년 대형차급으로 복귀" as string,
      //     originallink: "https://www.hankyung.com/car/article/2021032596012" as string,
      //     link: "https://www.hankyung.com/car/article/2021032596012" as string,
      //     description: "현대자동차가 그랜저의 지위를 준대형에서 대형 세단으로 격상할 전망이다. 1세대 '각 그랜저' 시절 성공의 상징으로 불렸던 플래그십 세단의 옛명성을 되찾는다는 계획이다." as string,
      //     pubDate: "2021.03.25 08:01" as string
      //   },
      //   {
      //     title: "현대차 7세대 그랜저, 2022년 대형차급으로 복귀" as string,
      //     originallink: "https://www.hankyung.com/car/article/2021032596012" as string,
      //     link: "https://www.hankyung.com/car/article/2021032596012" as string,
      //     description: "현대자동차가 그랜저의 지위를 준대형에서 대형 세단으로 격상할 전망이다. 1세대 '각 그랜저' 시절 성공의 상징으로 불렸던 플래그십 세단의 옛명성을 되찾는다는 계획이다." as string,
      //     pubDate: "2021.03.25 08:01" as string
      //   }
      // ]
      newsList: Array,
      isShowButton: true,
    };
  },
  methods: {
    // defaultNews(){
    //   const list = [];
    //   for (let i = 0; i < 2; i++) {
    //     list.push(this.newsData[i]);
    //   }
    //   console.log("this is news list : ", list)
    //   this.newsList = list;
    // },
    addNews(){
      this.isShowButton = false;
    }
  },
});
</script>
