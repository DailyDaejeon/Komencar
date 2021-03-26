<template>
  <nav class="nav">
      <input type="checkbox" class="nav-checkbox" id="nav-toggle">
      <label for="nav-toggle" class="nav-button">
        <span class="nav-icon">&nbsp;</span>
      </label>
      <div class="nav-bg">&nbsp;</div>
      <div class="nav-body">
        <ul class="nav-list">
          <li class="nav-item">
              <a 
              href="#"
              class="nav-link">
              <span><i class="fas fa-car"></i></span>내 차 관리
              </a>
          </li>
          <li class="nav-item">
              <a 
              href="#"
              class="nav-link">
              <span><i class="far fa-newspaper"></i></span>
              뉴스/정보 보기
              </a>
          </li>
          <li class="nav-item">
              <a
              href="#"
              class="nav-link">
              <span><i class="fas fa-shopping-cart"></i></span>
              추천 굿즈
              </a>
          </li>
          <li class="nav-item">
              <a
              href="#"
              class="nav-link">
              <span><i class="fas fa-share-alt"></i></span>
              스트리밍 서비스 확인
              </a>
          </li>
        </ul>
      </div>
    </nav>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  
})
</script>

<style>

</style>