<template>
  <div class="box">
    <div class="box__title">GOODS</div>
    <div class="box__subtitle">
      {{ CarModelName }} 에 어울리는 굿즈를 쇼핑해보세요
    </div>
    <div v-for="(goods, index) in goodsData" :key="index">
      <CarGoodsItem :goods="goods" />
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { fetchShops } from "@/api/index";
import CarGoodsItem from "@/components/carInfo/CarGoodsItem.vue";

export default Vue.extend({
  components: { CarGoodsItem },
  props: {
    // goodsData: {
    //   type: Array
    // }
  },
  data() {
    return {
      goodsData: [
        {
          title: "메이튼 자동차 코일매트 확장형" as string,
          link: "https://search.shopping.naver.com/catalog/17389272175?query=%EC%95%84%EB%B0%98%EB%96%BC&NaPm=ct%3Dkmvzg72w%7Cci%3D8a2bc10ffcfc486d4865cba0542ec26deadc261f%7Ctr%3Dslsl%7Csn%3D95694%7Chk%3D42539be5b4c0d4fba2d005e7eb15c3c6fdf5d005" as string,
          image: "https://shopping-phinf.pstatic.net/main_1738927/17389272175.3.20200922133836.jpg?type=f640" as string,
          lprice: "23,300" as string,
          hprice: "37,900" as string,
          mallName: "메이튼" as string
        },
        {
          title: "메이튼 자동차 코일매트 확장형" as string,
          link: "https://search.shopping.naver.com/catalog/17389272175?query=%EC%95%84%EB%B0%98%EB%96%BC&NaPm=ct%3Dkmvzg72w%7Cci%3D8a2bc10ffcfc486d4865cba0542ec26deadc261f%7Ctr%3Dslsl%7Csn%3D95694%7Chk%3D42539be5b4c0d4fba2d005e7eb15c3c6fdf5d005" as string,
          image: "https://shopping-phinf.pstatic.net/main_1738927/17389272175.3.20200922133836.jpg?type=f640" as string,
          lprice: "23,300" as string,
          hprice: "37,900" as string,
          mallName: "메이튼" as string
        },
        {
          title: "메이튼 자동차 코일매트 확장형" as string,
          link: "https://search.shopping.naver.com/catalog/17389272175?query=%EC%95%84%EB%B0%98%EB%96%BC&NaPm=ct%3Dkmvzg72w%7Cci%3D8a2bc10ffcfc486d4865cba0542ec26deadc261f%7Ctr%3Dslsl%7Csn%3D95694%7Chk%3D42539be5b4c0d4fba2d005e7eb15c3c6fdf5d005" as string,
          image: "https://shopping-phinf.pstatic.net/main_1738927/17389272175.3.20200922133836.jpg?type=f640" as string,
          lprice: "23,300" as string,
          hprice: "37,900" as string,
          mallName: "메이튼" as string
        }
      ]
    };
  },
  created() {
    this.getGoods();
  },
  methods: {
    async getGoods() {
      const response = await fetchShops(this.CarModelName);
      this.goodsData = response.data;
    }
  }
});
</script>
