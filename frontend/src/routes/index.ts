import Vue from "vue";
import VueRouter, { NavigationGuardNext, Route } from "vue-router";
import store from "@/store/index";

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "CarSearch",
      component: () => import("@/views/carSearch/CarSearch.vue")
    },
    {
      path: "/main",
      name: "Main",
      component: () => import("@/views/main/MainPage.vue")
    }
  ]
});
