<template>
  <div class="box">
    <div class="box__title">GOODS</div>
    <div class="box__subtitle">
      {{ CarModelName }} 에 어울리는 굿즈를 쇼핑해보세요
    </div>

    <div v-swiper:mySwiper="swiperOption" class="swiper-container">
      <div class="swiper-wrapper">
        <div v-for="(goods, index) in goodsData" :key="index" class="swiper-slide box__goodsBox">
          <CarGoodsItem :goods="goods" />
        </div>
      </div>
      <div class="swiper-pagination" v-if="slides.length > 1"></div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";

import CarGoodsItem from "@/components/carInfo/CarGoodsItem.vue";

export default Vue.extend({
  components: { 
    CarGoodsItem,
  },
  props: {
    goodsData: {
      type: Array
    },
    CarModelName: {
      type: String
    }
  },
  data() {
    return {
      slides: '',
        swiperOption: {
          loop: false,
          slidesPerView: 2,
          spaceBetween: 30,
          pagination: {
            el: '.swiper-pagination',
            clickable: true,
            dynamicBullets: true,
            dynamicMainBullets : 2
          },
          //반응형(화면 크기에 맞게 표출할 상품 수 정하기)
          breakpoints: {
            280: {
              slidesPerView: 1,
              spaceBetween: 10
            },

            370: {
              slidesPerView: 1,
              spaceBetween: 30
            },
            480: {
              slidesPerView: 2,
              spaceBetween: 10
            },
            640: {
              slidesPerView: 2,
              spaceBetween: 20
            },
            1264: {
              slidesPerView: 3,
              spaceBetween: 27
            }
          }
        },
    };
  },
});
</script>
