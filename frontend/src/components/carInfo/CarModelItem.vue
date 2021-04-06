<template>
  <div class="item-box">
    <div class="img-wrap">
      <img :src="getImg(compareCar.modelDetailList[0].name)" alt="" />
    </div>
    <div class="caption">
      <div class="caption__desc">
        <div class="caption__desc__title">
          {{ compareCar.name }} {{ compareCar.modelDetailList[0].name }}
        </div>
        <div class="caption__desc__detail">
          가격 : {{ compareCar.modelDetailList[0].optionList[0].price
          }}<br />연비 :
          {{ compareCar.modelDetailList[0].effciency }}
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
  },
  methods: {
    getImg(mName) {
      //내가 찍은 차 이미지 받아오는 메소드
      let name = mName.split(" ");
      name = name.join("_");
      return require(`@/assets/images/cars/${name}.jpg`);
    }
  }
});
</script>
