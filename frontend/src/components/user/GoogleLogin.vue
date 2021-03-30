<template>
  <div id="google-signin-btn">
    <button @click="login">
      <img
        src="@/assets/images/btn_google_signin_light_normal_web@2x.png"
        width="70%"
        alt="google-login-btn"
      />
    </button>
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import Vue from 'vue'
import { loginUser } from "@/api/index";

export default Vue.extend({
  methods: {
    // async login() {
    //   try {
    //   await this.$store.dispatch('LOGIN')
    // } catch (error) {
    //   console.log(error)
    // }
    // },
    login() {
      loginUser()
    },
  //   handleClickGetAuth(){
  //     this.$gAuth.getAuthCode()
  //     .then(authCode => {
  //       //on success
  //       console.log('Authcode',authCode)
  //       return this.$http.post('http://your-backend-server.com/auth/google', { code: authCode, redirect_uri: 'postmessage' })
  //     })
  //     .then(response => {
  //       //and then
  //       console.log(response)
  //       // this.handleClickSignIn()
  //       // 만약 토큰이 없으면 signin하고,,,이건 api만든 뒤에 다시 확인 필요
  //     })
  //     .catch(error => {
  //       //on fail do something
  //       console.log(error)
  //     })
  //   },
  
  // handleClickSignIn(){
  //     this.$gAuth.signIn()
  //   .then(GoogleUser => {
  //     //on success do something
  //     console.log('GoogleUser', GoogleUser) 
  //   })
  //   .catch(error  => {
  //     //on fail do something
  //     console.log(error)
  //   })
    // }
    }
})
</script>

<style>

</style>