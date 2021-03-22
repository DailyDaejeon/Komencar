<template>
  <div id="google-signin-btn">
    <button @click="handleClickGetAuth">
      <img src="@/assets/images/btn_google_signin_light_normal_web@2x.png" width="70%" alt="google-login-btn">
    </button>
    </div>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  methods: {
    handleClickGetAuth(){
      this.$gAuth.signIn()
    .then(GoogleUser => {
      //on success do something
      console.log('GoogleUser', GoogleUser) 
    })
    .catch(error  => {
      //on fail do something
      console.log(error)
    })
    }
    }
})
</script>

<style>

</style>