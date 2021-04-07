<template>
  <div class="carSearch">
    <h2 class="carSearch__descrip " id="typo">
      눈 앞의 차를 카메라로 찍어보고, 시세를 확인해보세요.
    </h2>
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
  created() {
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
