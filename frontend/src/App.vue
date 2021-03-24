<template>
  <div id="app">
    <CarNews/>
    <LoginPage/>
    <div>사진찍기</div>
    <CarSearch/>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import CarNews from './components/carInfo/CarNews.vue';
import CarSearch from './views/carSearch/CarSearch.vue';
import LoginPage from './views/user/LoginPage.vue';

export default Vue.extend({
  name: "App",
  components: { 
    LoginPage, 
    CarSearch,
    CarNews 
    },

});
</script>

<style>

</style>
