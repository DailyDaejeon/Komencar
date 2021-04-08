<template>
  <div>
    <a class="pushme"> <span class="inner">최신 모델과 비교</span></a>
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
      type: Object
    }
  },
  data() {
    return {
      chartLabel: ["연비(m/l)", "배기량(cc)", "가격(만원)"],
      modelName: "",
      carPrice: []
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
    console.log(
      "여긴차트 latestModel : ",
      this.latestModel,
      this.$store.state.latestModel
    );
    console.log("여긴 차트 modelInfo : ", this.modelInfo);
    const chart = new this.$_Chart(ctx, {
      type: "radar",
      fill: false,
      data: {
        labels: this.chartLabel,
        // datasets를 props로 받기
        datasets: [
          {
            label: `${this.latestModel.name} ${this.latestModel.optionList[0].name}`,
            data: [
              this.latestModel.effciency * 1000,
              this.latestModel.exhaust,
              this.latestModel.optionList[
                this.latestModel.optionList.length - 1
              ].price / 10000
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
            label: `${this.modelInfo.name} ${
              this.modelInfo.optionList[this.modelInfo.optionList.length - 1]
                .name
            }`,
            data: [
              this.modelInfo.effciency * 1000,
              this.modelInfo.exhaust,
              this.modelInfo.optionList[0].price / 10000
            ],
            fill: true,
            backgroundColor: "rgba(54, 162, 235, 0.2)",
            borderColor: "rgb(0, 44, 94)",
            pointBackgroundColor: "rgb(0, 44, 94)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(0, 44, 94)"
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
          titleFont: { style: "bold" },
          titleAlign: "center",
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
