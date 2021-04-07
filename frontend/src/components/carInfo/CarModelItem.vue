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
          가격 :
          {{
            compareCar.modelDetailList[0].optionList[0].price / 10000
          }}만원<br />연비 :
          {{ compareCar.modelDetailList[0].effciency }}
        </div>
      </div>
      <div
        class="caption__desc__button"
        @click="goDetail(compareCar.modelDetailList[0].name)"
      >
        See details
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { findModelId } from "@/api";
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
    },
    goDetail(mName) {
      findModelId(mName)
        .then(res => {
          console.log("제 정보는용", res.data);
          this.$store.commit("MODEL_INFO", res.data);
          this.$store.commit("MODEL_NAME", res.data.name);
          this.$store.dispatch("FETCH_LATEST", res.data.id);
          this.$store.dispatch("SIMILAR_PRICE", res.data.id);
          this.$store.dispatch("SAME_SEGMENT", res.data.id);
        })
        .then(() => {
          window.location.reload();
          window.scrollTo(0, 0);
        });
    }
  }
});
</script>
