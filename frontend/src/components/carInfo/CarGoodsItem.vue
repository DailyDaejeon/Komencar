<template>
  <div class="card">
    <div class="card__img">
      <img :src="this.goods.image" alt="굿즈이미지" width="150px" />
    </div>
    <div class="card__title" v-html="setGoodsTitle()"></div>
    <div class="card__details">최저 {{ goods.lprice | comma }}원</div>
    <div class="card__buy-button">
      <a :href="this.goods.link">
        <span class="card__buy-button__text">
          최저가 사러가기
          <span class="card__buy-button__icon">
            <i class="fas fa-shopping-cart"></i>
          </span>
        </span>
      </a>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  props: {
    goods: {
      type: Object
    }
  },
  filters: {
    comma(value) {
      const num = new Number(value);
      return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g, "$1,")
    }
  },
  methods: {
    setGoodsTitle(){
      if(this.goods.title.length > 26) {
        return this.goods.title.substr(0,26)+"...";
      }else {
        return this.goods.title;
      }
    } 
  },
});
</script>
