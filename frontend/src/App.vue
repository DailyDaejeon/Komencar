<template>
  <div id="app">
    <CarImagePage/>
    <!-- <LoginPage/>
    <CarSearch/> -->
    <router-view></router-view>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarImagePage from './views/carSearch/CarImagePage.vue';
// import CarSearch from './views/carSearch/CarSearch.vue';
// import LoginPage from './views/user/LoginPage.vue';

export default Vue.extend({
  components: { CarImagePage },
  name: "App",
});
</script>

<style>

</style>
