<template>
  <div class="spinner__container" v-if="loading">
    <div class="spinner__container__canvas">
      <div class="spinner__container__canvas__spinner"></div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    loading: {
      type: Boolean,
      required: true
    }
  }
};
</script>
