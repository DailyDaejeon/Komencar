<template>
  <nav class="nav">
    <input type="checkbox" class="nav-checkbox" id="nav-toggle" />
    <label for="nav-toggle" class="nav-button">
      <span class="nav-icon">&nbsp;</span>
    </label>
    <div class="nav-bg">&nbsp;</div>
    <div class="nav-body">
      <ul class="nav-list">
        <li class="nav-item">
          <a @click="goSearch" class="nav-link">
            <span><i class="fas fa-search"></i></span>차 검색하기
          </a>
        </li>
        <li class="nav-item">
          <a @click="goId('carSearchResult')" href="" class="nav-link">
            <span><i class="fas fa-car"></i></span>차 세부정보
          </a>
        </li>
        <template v-if="isShow">
          <li class="nav-item">
            <a @click="goId('carCompare')" href="#carCompare" class="nav-link">
              <span><i class="fas fa-share-alt"></i></span>
              차 모델 비교
            </a>
          </li>
          <li class="nav-item">
            <a
              @click="goId('carNewsInfo')"
              href="#carNewsInfo"
              class="nav-link"
            >
              <span><i class="far fa-newspaper"></i></span>
              뉴스/정보 보기
            </a>
          </li>
          <li class="nav-item">
            <a
              @click="goId('carGoodsInfo')"
              href="#carGoodsInfo"
              class="nav-link"
            >
              <span><i class="fas fa-shopping-cart"></i></span>
              추천 굿즈
            </a>
          </li>
        </template>
      </ul>
    </div>
  </nav>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  computed: {
    isShow(): boolean {
      if (this.$route.name !== "Main") {
        return false;
      }
      return true;
    }
  },
  methods: {
    goId(idName) {
      if (this.$route.name !== "Main" && window.sessionStorage["model-info"]) {
        this.$router.push({
          name: "Main",
          params: {
            goid: idName
          }
        });
      } else if (this.$route.name === "Main") {
        this.isShow = true;
        document.getElementById(idName).scrollIntoView({
          behavior: "smooth",
          block: "start",
          inline: "start"
        });
      } else {
        this.$swal({
          text: "차량에 대한 정보가 없습니다. 사진을 업로드해주세요",
          customClass: {
            container: "swal2-container"
          },
          icon: "warning",
          timer: 1300,
          showConfirmButton: false
        });
      }
      const bg = document.querySelector(".nav-checkbox") as HTMLInputElement;
      bg.checked = false;
    },
    goSearch() {
      this.$router.push({ name: "ModelSearchPage" });
      const bg = document.querySelector(".nav-checkbox") as HTMLInputElement;
      bg.checked = false;
    }
  }
});
</script>

<style></style>
