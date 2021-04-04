<template>
  <div class="search">
    <!-- <h2>자동차 검색</h2> -->
    <CarModelSearch />
    <!-- 검색한 결과가 v-for로 돌려 보이게 만듦 -->
  </div>
</template>
<script lang="ts">
import Vue from "vue";
import CarModelSearch from "@/components/carSearch/CarModelSearch.vue";

export default Vue.extend({
  components: { CarModelSearch }
});
</script>

<style></style>
