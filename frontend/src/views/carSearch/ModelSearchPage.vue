<template>
  <div>
    <h2>자동차 검색</h2>
    <input type="text" :value="keyword" @input="goSearch" />
    <i class="fas fa-search"></i>
  </div>
</template>
<script lang="ts">
import Vue from "vue";
import { searchCar } from "@/api/index";
export default Vue.extend({
  data() {
    return {
      keyword: {
        type: String,
        default: "grandeur"
      }
    };
  },
  methods: {
    goSearch() {
      searchCar(this.keyword).then(res => console.log(res));
    }
  }
});
</script>

<style></style>
