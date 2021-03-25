<template>
  <div class="container-fulid">
    <!-- 이미지 불러오기 -->
    <div class="img-box">
      <img :src="getImg()" width="200px" height="100%">
    </div>

    <!-- 정보 불러오기 -->
    <div class="car-info">
      모델명 : {{carModel}}<br>
      출고가격 : {{carCost}}<br>
      연비 : {{carFE}}<br>
      제조사 : {{carMF}}<br>
      판매 : {{carSale}}<br>
    </div>

    <div class="add-box" v-if="!isAddToMyCar">
      <p>{{carModel}}을(를) '내 차량'으로 등록하고 코멘카에서 제공하는 더 풍부하고 많은 혜택을 즐겨보세요!</p>
      <!-- 비회원 이용 시 -->
      <!-- <router-link :to="{name:'LoginPage'}">로그인 하러 가기</router-link> -->
      <p class="goToLogin" v-if="!isLogin">로그인 하러 가기</p>

      <!-- 회원 이용 시 -->
        <!-- 내 차 미등록 시 -->
        <!-- <p @click="addToMyCar">내 차로 등록하기</p> -->
        <p class="addToMyCar" v-else>내 차로 등록하기</p>
    </div>
    <div class="add-box-tail"></div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  data() {
    return {
      myCarImg: '', //서버에서 받아온 이미지 주소 저장
      carModel: '', //차 모델 명
      carCost: '', //차 가격
      carFE: '', //차 연비
      carMF: '', //차 제조사
      carSale: '', //차 판매국
    }
  },
  created() {
    this.fetchCarInfo();
  },
  methods: {
    fetchCarInfo(){ //차 정보 받아오는 메소드
      this.carModel = '현대 코나';
      this.carCost = '1962 ~ 2697(만원)';
      this.carFE = '10.0 ~ 18.6km/ℓ';
      this.carMF = '현대자동차';
      this.carSale = '국내출시';
    },
    getImg(){ //내가 찍은 차 이미지 받아오는 메소드
      this.myCarImg = require('@/assets/images/testCar.jpg');
      return this.myCarImg;
    }
  },
})
</script>

<style>

</style>