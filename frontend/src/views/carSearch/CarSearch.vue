<template>
  <div>
    <CarGellery/>
    <!-- <CarCamera/> -->
  </div>

</template>
<script lang="ts">
// import CarCamera from '@/components/carSearch/CarCamera.vue'
import CarGellery from '@/components/carSearch/CarGellery.vue'
import Vue from 'vue'
export default Vue.extend({
  components: { 
    CarGellery, 
    // CarCamera 
  },
  
})
</script>

<style>

</style>