<template>
  <div>
    <a class="pushme"> <span class="inner">출시가</span></a>
    <p class="price__typo">
      {{ lowPrice | comma }} ~ {{ highPrice | comma }} 만원
    </p>
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
      chartLabel: [],
      modelName: "the new grandeur",
      carPrice: [],
      lowPrice: 0,
      highPrice: 0
    };
  },
  filters: {
    comma(value) {
      const num = new Number(value);
      return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g, "$1,");
    }
  },
  created() {
    this.getDataSet();
    this.setPrice();
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
            borderColor: "rgb(0, 44, 94)",
            data: this.carPrice,
            pointBackgroundColor: "rgb(0, 44, 94)"
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
      // if (!this.chartLabel && !this.carPrice) {
      this.allOptions.forEach(option => {
        this.chartLabel.push(option.name);
        this.carPrice.push(option.price);
      });
      // }
    },
    setPrice() {
      const low = this.allOptions[0].price;
      const high = this.allOptions[this.allOptions.length - 1].price;

      this.lowPrice = low / 10000;
      this.highPrice = high / 10000;
    }
  }
});
</script>

<style scoped></style>
