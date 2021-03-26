<template>
  <div id="app">
    <Nav/>
    <main>
    <!-- <div class="u-margin-top-big"></div> -->
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
