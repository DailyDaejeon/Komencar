<template>
  <div>
    <h2>내차 예상시세</h2>
    <p class="price__typo">{{ MinCarPrice }} ~ {{ MaxCarPrice }}</p>
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
      fill: false,
      data: {
        labels: this.chartLabel,
        // datasets를 props로 받기
        datasets: [
          {
            showLine: true,
            label: this.modelName,
            backgroundColor: "rgba(255, 99, 132, 0)",
            borderColor: "rgb(40, 75, 99)",
            data: this.carPrice,
            pointBackgroundColor: "rgb(40, 75, 99)"
          }
        ]
      },

      options: {
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
        },
        scales: {
          xAxes: [
            {
              gridLines: {
                display: false,
                color: "black"
              },
              scaleLabel: {
                display: true,
                labelString: "Options",
                fontColor: "black"
              }
            }
          ],
          yAxes: [
            {
              type: "linear",
              position: "top",
              ticks: {
                display: true,
                stepSize: 5000000,
                callback: function(value, index, values) {
                  // value = value.toString().slice(0, 4);
                  return value / 10000 + "만원";
                }
              },
              gridLines: {
                display: false,
                color: "gray"
                // zeroLineBorderDash: [2, 5]
              },
              scaleLabel: {
                display: false,
                labelString: "Price"
              }
            }
          ]
        }
      }
    });
  }
});
</script>

<style scoped></style>
