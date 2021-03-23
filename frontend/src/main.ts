import Vue from "vue";
import App from "./App.vue";
<<<<<<< HEAD
import router from "./routes/index";
import store from "./store/index";
// import '@/css/index.css'
import GAuth from 'vue-google-oauth2'

Vue.use(GAuth, {clientId: '239626612902-num4kon1amg6h3bkgart12e1q18hqprq.apps.googleusercontent.com', scope: 'profile email https://www.googleapis.com/auth/plus.login'})
=======
>>>>>>> 195dafdae9287fdcc86cea3f94a2cb102b744cd8

Vue.config.productionTip = false;

new Vue({
<<<<<<< HEAD
  router,
  store,
=======
>>>>>>> 195dafdae9287fdcc86cea3f94a2cb102b744cd8
  render: h => h(App)
}).$mount("#app");
