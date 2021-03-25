<template>
  <div>
    <h2>
      눈 앞의 차를 카메라로 찍어보고, 시세를 확인해보세요.
    </h2>
    <CarImages 
    imageMethod="camera"
    />
    <CarImages
    imageMethod="gallery"
    />
  </div>

</template>
<script lang="ts">
import CarImages from '@/components/carSearch/CarImages.vue'
import Vue from 'vue'
export default Vue.extend({
  components: { 
    CarImages,
  },
  
})
</script>

<style>

</style>