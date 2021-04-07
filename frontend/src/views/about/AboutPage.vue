<template>
  <div>
    <template v-if="isShow"><About></About></template>
    <template v-else>
      <section class="wrap-3d">
        <div class="item-3d">
          <figure class="item-content">
            <figcaption class="item-caption">
              <div class="item-caption-main">
                <span class="item-caption-strong">AI 코멘카</span>가 알려주는
                <span class="item-caption-strong"> 가격정보</span><br />
              </div>
              <div class="item-caption-sub">
                눈 앞에 있는 차를
                <strong>카메라로</strong> 찍고,
                <strong>가격까지</strong>
                한번에 확인할 수 있어요
              </div>
              <div class="arrow_box">
                <div class="arrow_box_left">
                  이거 얼마야?<img
                    src="../../assets/images/thinking.png"
                    alt=""
                    class="arrow_box__icon"
                  />
                </div>
                <div class="arrow_box_right">
                  4,791~5,724만원입니다.<img
                    src="../../assets/images/blowkiss.png"
                    alt=""
                    class="arrow_box__icon"
                  />
                </div>
              </div>
            </figcaption>
            <div class="item-img">
              <img src="../../assets/images/the_new_grandeur.png" alt="" />
            </div>
          </figure>
        </div>
        <div class="about-button" @click="gotoHome()">
          <span class="about-button__detail">코멘카 바로가기</span>
        </div>
      </section>
    </template>
  </div>
</template>

<script lang="ts">
import About from "@/components/about/About.vue";
import Vue from "vue";

export default Vue.extend({
  components: { About },
  data() {
    return {
      isShow: true
    };
  },
  created() {
    setTimeout(() => {
      this.isShow = false;
    }, 4500);
  },
  methods: {
    gotoHome() {
      this.$router.push({ name: "Home" });
    }
  }
});
</script>

<style></style>
