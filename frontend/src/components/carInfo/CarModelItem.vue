<template>
    <div>
        {{ compareCar.m_name }}
        
        <img :src="this.compareCar.m_image" alt="비교분석이미지" width="150px">
        {{ compareCar.m_price }}
        {{ compareCar.m_effciency }}


    </div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  props: {
    compareCar: {
      type: Object
    }
  }
});
</script>
