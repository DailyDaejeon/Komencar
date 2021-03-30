<template>
  <div>
    {{ goods }}
  </div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  props: {
    goods: {
      type: Object
    }
  }
});
</script>

<style></style>
