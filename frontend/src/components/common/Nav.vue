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
          <a @click="goSearch()" class="nav-link">
            <span><i class="fas fa-search"></i></span>차 검색하기
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link">
            <span><i class="fas fa-car"></i></span>차 세부정보
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link">
            <span><i class="far fa-newspaper"></i></span>
            뉴스/정보 보기
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link">
            <span><i class="fas fa-shopping-cart"></i></span>
            추천 굿즈
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link">
            <span><i class="fas fa-share-alt"></i></span>
            스트리밍 서비스
          </a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  methods: {
    goSearch() {
      this.$router.push({ name: "ModelSearchPage" });
      window.location.reload();
    },
    alertExample() {
      this.$swal({
        // https://sweetalert2.github.io/#usage 여기서 사용법 참고
        customClass: {
          container: "swal2-container" // class 적음 -> utilities에 적어둠, 커스텀 가능
        },
        title: "alert 제목을 적으세요",
        text: "로그인하러 가시겠습니까?",
        // icon warning, error, success, info, and question 중 고름
        icon: "info",
        // iconColor:'#ffffff',
        // timer: 1300,
        showConfirmButton: true,
        confirmButtonText: "OK",
        showCancelButton: true,
        cancelButtonText: "Cancel"
      }).then(() => {
        // 확인을 누른다면 로그인페이지로 이동
        this.$router.push({ name: "Login" });
        // window.location.reload();
      });
    }
  }
});
</script>

<style></style>
