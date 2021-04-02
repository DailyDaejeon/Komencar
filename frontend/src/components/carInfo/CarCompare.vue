<template>
  <div>
    <h2>최신 모델과 비교</h2>
    <div class="chart-container">
      <canvas id="myCompareChart"></canvas>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  props: {
    latestModel: {
      type: Object
    },
    modelInfo: {
      type: Object || Array
    }
  },
  data() {
    return {
      chartLabel: ["연비", "배기량", "가격"],
      modelName: "the new grandeur",
      carPrice: [33550000, 34300000, 37500000, 41850000]
    };
  },
  mounted() {
    const canvasElement = document.getElementById(
      "myCompareChart"
    ) as HTMLCanvasElement;
    const ctx = canvasElement.getContext("2d");
    // null값처리
    if (!ctx) {
      return;
    }

    const chart = new this.$_Chart(ctx, {
      type: "radar",
      fill: false,
      data: {
        labels: this.chartLabel,
        // datasets를 props로 받기
        datasets: [
          {
            label: this.latestModel.md_name,
            data: [
              this.latestModel.md_efficiency,
              this.latestModel.md_exhaust,
              this.latestModel.optionList.o_price
            ],
            fill: true,
            backgroundColor: "rgba(255, 99, 132, 0.2)",
            borderColor: "rgb(255, 99, 132)",
            pointBackgroundColor: "rgb(255, 99, 132)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(255, 99, 132)"
          },
          {
            label: this.modelInfo.m_name,
            data: [
              this.modelInfo.m_efficiency,
              this.modelInfo.md_exhaust,
              this.modelInfo.m_price
            ],
            fill: true,
            backgroundColor: "rgba(54, 162, 235, 0.2)",
            borderColor: "rgb(31, 156, 253)",
            pointBackgroundColor: "rgb(31, 156, 253)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(31, 156, 253)"
          }
        ]
      },

      options: {
        elements: {
          line: {
            borderWidth: 3
          }
        },
        tooltips: {
          mode: "index",
          intersect: false
        },
        hover: {
          mode: "nearest",
          intersect: true
        },
        maintainAspectRatio: false,
        aspectRatio: 1,
        legend: {
          display: true,
          position: "top",
          align: "end",
          usePointStyle: true,
          // pointStyle: "circle"
          labels: {
            boxWidth: 1,
            fontColor: "black"
          }
        }
      }
    });
  }
});
</script>

<style scoped></style>
