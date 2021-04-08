import Vue from "vue";
import Chart = require("chart.js");
import { MyStore } from "@/store/types";

type ChartLib = typeof Chart;
declare module "vue/types/vue" {
  interface Vue {
    $_Chart: ChartLib;
  }
}

// NOTE: `node_module/vuex/types/vue.d.ts` 파일을 삭제해줘야 아래 타입이 정상 추론됨
declare module "vue/types/vue" {
  interface Vue {
    $store: MyStore;
  }
}

declare module "vue/types/options" {
  interface ComponentOptions<V extends Vue> {
    store?: MyStore;
  }
}
