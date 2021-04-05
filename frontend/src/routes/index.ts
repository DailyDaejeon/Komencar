import Vue from "vue";
import VueRouter, { NavigationGuardNext, Route } from "vue-router";
import store from "@/store/index";

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "AboutPage",
      component: () => import("@/views/about/AboutPage.vue")
    },
    {
      path: "/home",
      name: "CarSearch",
      component: () => import("@/views/carSearch/CarSearch.vue")
    },
    {
      path: "/main",
      name: "Main",
      component: () => import("@/views/main/MainPage.vue"),
      props: true
    },
    {
      path: "/search",
      name: "ModelSearchPage",
      component: () => import("@/views/carSearch/ModelSearchPage.vue"),
      props: true
    }
  ]
});
