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
      component: () => import('@/views/carSearch/CarSearch.vue')
    },
    {
      path: '/carSearch/result',
      name: 'CarSearchResult',
      component: () => import('@/views/carSearch/CarSearchDetailPage.vue')
    },
    {
      path: '/carInfo/news',
      name: 'CarNews',
      component: () => import('@/components/carInfo/CarNews.vue')
    },
  ]
});
