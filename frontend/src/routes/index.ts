import Vue from "vue";
import VueRouter, { NavigationGuardNext, Route } from "vue-router";
import store from "@/store/index";

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: '/',
      name: 'Main',
      // component: loadComponent('Main','Main'),
      component: () => import('@/views/carSearch/CarSearch.vue')
    },
    {
      path: '/carSearch/result',
      name: 'carSearchResult',
      // component: loadComponent('Main','Main'),
      component: () => import('@/views/carSearch/CarSearchDetailPage.vue')
    },
  ]
});
