<template>
  <div>
    <h2>차 예상시세</h2>
    <p class="price__typo">{{ MinCarPrice }} ~ {{ MaxCarPrice }}</p>
    <div class="chart-container">
      <canvas id="myPriceChart"></canvas>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  props: {
    allOptions: {
      type: Array
    },
    mdName: {
      type: String,
      default: "the new grandeur"
    }
  },
  data() {
    return {
      chartLabel: ["Premium", "Premium Choice", "Exclusive", "Calligraphy"],
      modelName: "the new grandeur",
      carPrice: [33550000, 34300000, 37500000, 41850000]
    };
  },
  created() {
    this.getDataSet();
  },
  mounted() {
    const canvasElement = document.getElementById(
      "myPriceChart"
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
            label: this.mdName,
            backgroundColor: "rgba(255, 99, 132, 0)",
            borderColor: "rgb(31, 156, 253)",
            data: this.carPrice,
            pointBackgroundColor: "rgb(31, 156, 253)"
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
                display: false,
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
  },
  methods: {
    getDataSet() {
      if (!this.chartLabel && !this.carPrice) {
        this.allOptions.forEach(option => {
          this.chartLabel.push(option.name);
          this.carPrice.push(option.price);
        });
      }
    }
  }
});
</script>

<style scoped></style>
