<template>
  <div>
    <h1>{{ CarModelName }}의 최신 정보를 확인해보세요</h1>
    <CarNewsItem
    :NewsTitle="NewsTitle"
    :NewsContext="NewsContext"/>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarNewsItem from '@/components/carInfo/CarNewsItem.vue';

export default Vue.extend({
  components: { CarNewsItem },

  props: {
    CarModelName : {
      type : String,
      default : "그랜저"
    }
  }

});
</script>

<style></style>
