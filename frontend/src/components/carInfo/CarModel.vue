<template>
  <div class="fullwidth">
    <div class="gallery">
      <div v-for="(compareCar, index) in CompareCar" :key="index" class="item">
        <CarModelItem :compareCar="compareCar" />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarModelItem from "./CarModelItem.vue";
export default Vue.extend({
  components: { CarModelItem },
  // props: {
  //   CompareCar: {
  //     type: Array
  //   }
  // },
  data() {
    return {
      CompareCar: [
        {
          m_id: 1 as number,
          m_manufacturer: "현대자동차" as string,
          m_name: "2021 코나" as string,
          m_price: 2000 as number, //이건 왜 인트로 들어가지?
          m_effciency: 11.6 as number,
          m_image: "https://search.pstatic.net/common?type=ofullfill&size=202x152&quality=95&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20201015_225%2Fauto_1602725331844aN0HF_JPEG%2F20201015102835_FdjdngRs.jpg" as string
        },
        {
          m_id: 1 as number,
          m_manufacturer: "현대자동차" as string,
          m_name: "2021 코나" as string,
          m_price: 2000 as number, //이건 왜 인트로 들어가지?
          m_effciency: 11.6 as number,
          m_image: "https://search.pstatic.net/common?type=ofullfill&size=202x152&quality=95&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20201015_225%2Fauto_1602725331844aN0HF_JPEG%2F20201015102835_FdjdngRs.jpg" as string
        },
        {
          m_id: 1 as number,
          m_manufacturer: "현대자동차" as string,
          m_name: "2021 코나" as string,
          m_price: 2000 as number, //이건 왜 인트로 들어가지?
          m_effciency: 11.6 as number,
          m_image: "https://search.pstatic.net/common?type=ofullfill&size=202x152&quality=95&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20201015_225%2Fauto_1602725331844aN0HF_JPEG%2F20201015102835_FdjdngRs.jpg" as string
        }
      ]
    };
  }
});
</script>

<style></style>
