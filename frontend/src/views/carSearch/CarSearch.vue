<template>
  <div class="carSearch">
    <div class="carSearch__descrip " id="typo">
      <p>눈 앞의 차를 카메라로 찍고,</p>
      <p>시세를 확인해보세요.</p>
    </div>
    <CarImages @active="toggleActive(true)" @unactive="toggleActive(false)" />
  </div>
</template>
<script lang="ts">
import CarImages from "@/components/carSearch/CarImages.vue";
import Vue from "vue";
export default Vue.extend({
  components: {
    CarImages
  },
  mounted() {
    this.toggleActive(true);
  },
  methods: {
    toggleActive(isActive) {
      const element = document.getElementById("typo");
      if (isActive) {
        element.classList.remove("descrip-active");
      } else {
        element.classList.add("descrip-active");
      }
    }
  }
});
</script>

<style></style>
