<template>
  <div class="search">
    <!-- <h2>자동차 검색</h2> -->
    <CarModelSearch />
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
