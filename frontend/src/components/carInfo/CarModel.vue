<template>
  <div class="fullwidth">
    <div class="gallery">
      <div v-for="(compareCar, index) in CompareCars" :key="index" class="item">
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
  props: {
    CompareCars: {
      type: Array
    }
  }
});
</script>

<style></style>
