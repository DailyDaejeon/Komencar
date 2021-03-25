<template>
  <div>
    <h2>
      차량 알아보기 결과 페이지
    </h2>
    <CarSearchResult/>
  </div>

</template>

<script lang="ts">
import CarSearchResult from '@/components/carSearch/CarSearchResult.vue'
import Vue from 'vue'
export default Vue.extend({
  components: { 
    CarSearchResult,
  },
})
</script>

<style>

</style>