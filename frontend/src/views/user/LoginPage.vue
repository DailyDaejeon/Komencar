<template>
  <div>
    <h2>
      로그인
    </h2>
    <h4>
      로그인을 하고, 코멘카가 제공하는 혜택을 받아보세요
    </h4>
    <GoogleLogin />
  </div>
</template>

<script lang="ts">
import GoogleLogin from "@/components/user/GoogleLogin.vue";
import Vue from "vue";
export default Vue.extend({
  components: { GoogleLogin }
});
</script>

<style></style>
