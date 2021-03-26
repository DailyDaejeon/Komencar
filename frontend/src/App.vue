<template>
  <div id="app">
    <Nav/>
    <h1>Komencar</h1>
    <main>
    <router-view></router-view>
    </main>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import Nav from './components/common/Nav.vue';

export default Vue.extend({
  components: { Nav },
  name: "App",
});
</script>

<style>

</style>
