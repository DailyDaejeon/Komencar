<template>
  <div id="app">
    <LoginPage/>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import LoginPage from './views/user/LoginPage.vue';

export default Vue.extend({
  components: { LoginPage },
  name: "App",
  
});
</script>

<style>

</style>
