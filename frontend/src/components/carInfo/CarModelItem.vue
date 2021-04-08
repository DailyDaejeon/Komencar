<template>
  <div class="item-box" v-if="isNotSame">
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
          }}만원<br />연비 : {{ compareCar.modelDetailList[0].effciency }}km/L
        </div>
      </div>

      <div class="mid">
        <div class="mid__text">
          자세한 정보가 궁금하다면 버튼을 클릭해주세요<span
            class="mid__text__icon"
            ><i class="fas fa-long-arrow-alt-down"></i
          ></span>
        </div>
        <label class="rocker">
          <input
            type="checkbox"
            @click="goDetail(compareCar.modelDetailList[0].name)"
          />
          <span class="switch-left">ON</span>
          <span class="switch-right">Off</span>
        </label>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { findModelId } from "@/api";
import bus from "@/utils/bus";
import Vue from "vue";
export default Vue.extend({
  props: {
    compareCar: {
      type: Object
    }
  },
  computed: {
    isNotSame(): boolean {
      if (
        this.$store.state.modelInfo.modelDetailList[0].id !==
        this.compareCar.modelDetailList[0].id
      ) {
        return true;
      } else {
        return false;
      }
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
      bus.$emit("on:progress");
      window.scrollTo(0, 0);
      findModelId(mName).then(res => {
        sessionStorage.clear();
        this.$store.commit("MODEL_INFO", res.data);
        this.$store.commit("MODEL_NAME", res.data.name);
        this.$store.dispatch("FETCH_LATEST", res.data.id);
        this.$store.dispatch("SIMILAR_PRICE", res.data.modelDetailList[0].id);
        this.$store.dispatch("SAME_SEGMENT", res.data.modelDetailList[0].id);
        setTimeout(() => {
          bus.$emit("on:progress");
          window.location.reload();
          window.scrollTo(0, 0);
        }, 3000);
      });
    }
    // gotoDetail() {
    //   this.$router.push({ name: "Home" });
    // }
  }
});
</script>
