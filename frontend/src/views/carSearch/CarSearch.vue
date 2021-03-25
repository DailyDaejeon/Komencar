<template>
  <div>
    <h2>
      눈 앞의 차를 카메라로 찍어보고, 시세를 확인해보세요.
    </h2>
    <CarGellery/>
  </div>

</template>
<script lang="ts">
import CarGellery from '@/components/carSearch/CarGellery.vue'
import Vue from 'vue'
export default Vue.extend({
  components: { 
    CarGellery,
  },
  
})
</script>

<style>

</style>