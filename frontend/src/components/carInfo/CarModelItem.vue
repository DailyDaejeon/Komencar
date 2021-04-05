<template>
  <div class="item-box">
    <div class="img-wrap">
      <img :src="this.compareCar.m_image" alt="" />
    </div>
    <div class="caption">
      <div class="caption__desc">
        <div class="caption__desc__title">{{ compareCar.m_name }}</div>
        <div class="caption__desc__detail">
          가격 : {{ compareCar.m_price }}<br />연비 :
          {{ compareCar.m_effciency }}
        </div>
      </div>
      <a class="caption__desc__button" href="#">See details</a>
    </div>
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
