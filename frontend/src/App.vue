<template>
  <div id="app">
    <Nav />
    <h1 class="LOGO">KOMENCAR</h1>
    <div class="Logo__sign">
      <span class="Logo__fast-flicker">KO</span>MEN<span class="Logo__flicker"
        >C</span
      >AR
    </div>
    <main>
      <router-view></router-view>
    </main>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import Nav from "@/components/common/Nav.vue";

export default Vue.extend({
  components: { Nav },
  name: "App"
});
</script>

<style></style>
