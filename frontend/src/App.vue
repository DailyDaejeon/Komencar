<template>
  <div id="app">
    <!-- <LoginPage/>
    <CarSearch/> -->
    <router-view></router-view>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
// import CarSearch from './views/carSearch/CarSearch.vue';
// import LoginPage from './views/user/LoginPage.vue';

export default Vue.extend({
  name: "App",
});
</script>

<style>

</style>
