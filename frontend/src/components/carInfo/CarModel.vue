<template>
  <div>
    <h1>모델 비교</h1>
    {{ CompareCar.m_name }}
  </div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  props: {
    CompareCar: {
      type: Array
    }
  }
});
</script>

<style></style>
