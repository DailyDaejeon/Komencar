<template>
  <div>
    <h2>내차 예상시세</h2>
    <p>{{ MinCarPrice }} ~ {{ MaxCarPrice }}</p>
    <div
      class="chart-container"
    >
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
      default: 0
    },
    MaxCarPrice: {
      type: Number,
      default: 100000000
    }
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
        labels: [
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July"
        ],
        // datasets를 props로 받기
        datasets: [
          {
            label: "2020년형 그랜저",
            backgroundColor: "rgb(255, 99, 132)",
            borderColor: "rgb(255, 99, 132)",
            data: [0, 10, 5, 2, 20, 30, 45]
          }
        ]
      },

      options: {
        maintainAspectRatio:false,
        aspectRatio:1,
      }
    });
  }
});
</script>

<style scoped></style>
