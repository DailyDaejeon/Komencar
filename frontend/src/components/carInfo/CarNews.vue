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
      newsList: Array,
      isShowButton: true
    };
  },
  methods: {
    addNews() {
      this.isShowButton = false;
    }
  }
});
</script>
