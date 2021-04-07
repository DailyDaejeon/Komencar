<template>
  <div id="app">
    <spinner :loading="loading"></spinner>
    <Nav v-if="isShow" />
    <h1 v-if="isShow" class="LOGO" @click="goImgSearch">KOMENCAR</h1>
    <!-- <div class="Logo__sign">
      <span class="Logo__fast-flicker">KO</span>MEN<span class="Logo__flicker"
        >C</span
      >AR
    </div> -->
    <main>
      <router-view></router-view>
    </main>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import Nav from "@/components/common/Nav.vue";
import Spinner from "@/components/common/Spinner.vue";
import bus from "@/utils/bus";

export default Vue.extend({
  components: { Nav, Spinner },
  name: "App",
  data() {
    return {
      isShow: true as boolean,
      loading: false
    };
  },
  watch: {
    $route() {
      if (this.$route.name !== "AboutPage") {
        this.isShow = true;
      } else {
        this.isShow = false;
      }
    }
  },
  methods: {
    goImgSearch() {
      this.$router.push({ name: "CarSearch" });
    },
    onProgress() {
      this.loading = true;
    },
    offProgress() {
      this.loading = false;
    }
  },
  async created() {
    bus.$on("on:progress", this.onProgress);
    bus.$on("off:progress", this.offProgress);
  }
});
</script>

<style></style>
