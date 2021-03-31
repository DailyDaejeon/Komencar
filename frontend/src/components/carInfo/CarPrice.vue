<template>
  <div>
    <h2>내차 예상시세</h2>
    <p>{{ MinCarPrice }} ~ {{ MaxCarPrice }}</p>
    <div class="chart-container">
      <canvas id="myChart"></canvas>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  props: {
    MinCarPrice: {
      type: Number,
      default: 33550000
    },
    MaxCarPrice: {
      type: Number,
      default: 41850000
    }
  },
  data() {
    return {
      chartLabel: ["Premium", "Premium Choice", "Exclusive", "Calligraphy"],
      modelName: "the new grandeur",
      carPrice: [33550000, 34300000, 37500000, 41850000]
    };
  },
  mounted() {
    const canvasElement = document.getElementById(
      "myChart"
    ) as HTMLCanvasElement;
    const ctx = canvasElement.getContext("2d");
    // null값처리
    if (!ctx) {
      return;
    }

    const chart = new this.$_Chart(ctx, {
      type: "line",
      data: {
        labels: this.chartLabel,
        // datasets를 props로 받기
        datasets: [
          {
            label: this.modelName,
            backgroundColor: "rgb(255, 99, 132)",
            borderColor: "rgb(255, 99, 132)",
            data: this.carPrice
          }
        ]
      },

      options: {
        maintainAspectRatio: false,
        aspectRatio: 1
      }
    });
  }
});
</script>

<style scoped></style>
