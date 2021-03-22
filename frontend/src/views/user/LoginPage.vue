<template>
  <div>
    <GoogleLogin/>
  </div>
</template>

<script lang="ts">
import GoogleLogin from '@/components/user/GoogleLogin.vue'
import Vue from 'vue'
export default Vue.extend({
  components: { GoogleLogin },
})
</script>

<style>

</style>