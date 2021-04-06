<template>
  <div class="card">
    <div class="card__img">
      <img :src="this.goods.image" alt="굿즈이미지" width="150px" />
    </div>
    <div class="card__title" v-html="setGoodsTitle()"></div>
    <div class="card__details">최저 {{ goods.lprice }}원</div>
    <!-- </ul> -->
    <div class="card__buy-button">
      <span class="card__buy-button__text"
        >최저가 사러가기<span class="card__buy-button__icon"
          ><i class="fas fa-shopping-cart"></i></span
      ></span>
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
  methods: {
    setGoodsTitle(){
      if(this.goods.title.length > 28) {
        return this.goods.title.substr(0,27)+"...";
      }else {
        return this.goods.title;
      }
    } 
  },
});
</script>
