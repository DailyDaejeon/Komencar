import Vue from "vue";
import App from "./App.vue";
import router from "./routes/index";
import store from "./store/index";
import "@/css/index.css";
import GAuth from "vue-google-oauth2";
import ChartPlugin from "@/plugins/ChartPlugin";
import VueSweetalert2 from "vue-sweetalert2";
import "sweetalert2/dist/sweetalert2.min.css";

Vue.use(VueSweetalert2);
Vue.use(ChartPlugin);
Vue.use(GAuth, {
  clientId:
    "239626612902-num4kon1amg6h3bkgart12e1q18hqprq.apps.googleusercontent.com",
  scope: "profile email"
});

// Vue.use(VueWebCam)

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
