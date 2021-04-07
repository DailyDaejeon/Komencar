import Vue from "vue";
import VueRouter, { NavigationGuardNext, Route } from "vue-router";
import bus from "@/utils/bus";

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
      name: "Home",
      component: () => import("@/views/carSearch/CarSearch.vue")
    },
    {
      path: "/main",
      name: "Main",
      component: () => import("@/views/main/MainPage.vue"),
      async beforeEnter(
        routeTo: Route,
        routeFrom: Route,
        next: NavigationGuardNext<Vue>
      ) {
        bus.$emit("on:progress");
        next();
      },
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
