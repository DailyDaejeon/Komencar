<template>
  <div class="container-fluid">
    <!-- 이미지 불러오기 -->
    <!-- 자신이 촬영한 이미지를 올리는게 좋을지, 기본 모델 이미지를 올리는게 좋을지 고민 중 -->
    <div class="container-fluid__img-box">
      <img :src="getImg()" />
    </div>
    <!-- 정보 불러오기-->
    <table class="container-fluid__car-info">
      <!-- <tbody> -->
      <tr>
        <th>모델</th>
        <td>
          <span>{{ carModel }}</span>
        </td>
      </tr>
      <tr>
        <th>출고가격</th>
        <td>
          <span>{{ carCost }}</span>
        </td>
      </tr>
      <tr>
        <th>연비</th>
        <td>
          <span>{{ carFE }}</span>
        </td>
      </tr>
      <tr>
        <th>제조사</th>
        <td>
          <span>{{ carMF }}</span>
        </td>
      </tr>
      <tr>
        <th>판매</th>
        <td>
          <span>{{ carSale }}</span>
        </td>
      </tr>
    </table>

    <div class="container-fluid__add-box" v-if="!isAddToMyCar">
      <p class="container-fluid__add-box-desc">
        <i class="fas fa-check"></i>{{ carModel }}을(를) '내 차량'으로 등록하고
        코멘카에서 제공하는 더 풍부하고 많은 혜택을 즐겨보세요
      </p>
      <!-- 비회원 이용 시 -->
      <!-- <router-link :to="{name:'LoginPage'}">로그인 하러 가기</router-link> -->
      <p class="container-fluid__add-box-login" v-if="!isLogin">
        <i class="fas fa-check"></i><U>로그인 하러 가기</U>
      </p>

      <!-- 회원 이용 시 -->
      <!-- 내 차 미등록 시 -->
      <!-- <p @click="addToMyCar">내 차로 등록하기</p> -->
      <p class="addToMyCar" v-else>내 차로 등록하기</p>
    </div>
    <div class="add-box-tail"></div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  data() {
    return {
      // isAddToMyCar: false,
      myCarImg: "", //서버에서 받아온 이미지 주소 저장
      carModel: "", //차 모델 명
      carCost: "", //차 가격
      carFE: "", //차 연비
      carMF: "", //차 제조사
      carSale: "" //차 판매국
    };
  },
  created() {
    // this.fetchMyCar();
    this.fetchCarInfo();
  },
  methods: {
    fetchMyCar() {
      this.isAddToMyCar = true;
    },
    fetchCarInfo() {
      //차 정보 받아오는 메소드
      this.carModel = "현대 코나";
      this.carCost = "1962 ~ 2697(만원)";
      this.carFE = "10.0 ~ 18.6km/ℓ";
      this.carMF = "현대자동차";
      this.carSale = "국내출시";
    },
    getImg() {
      //내가 찍은 차 이미지 받아오는 메소드
      this.myCarImg = require("@/assets/images/testCar.jpg");
      return this.myCarImg;
    },
    addToMyCar() {
      //내 계정 정보에 등록 여부를 보내주는 api 필요 => post...?
      try {
        // const result = await addToMyCar(this.carModel)
        const result = 1;
        if (result == 1) {
          window.alert("관심 목록에 저장했습니다.");
          // this.$router.push('interestCarList');
        } else {
          window.alert(
            "관심 목록에 저장하던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요."
          );
        }
      } catch (error) {
        // console.log(error);
        window.alert(error);
        window.alert(
          "관심 목록에 저장하던 중 오류가 발생했습니다.\n 잠시후 다시 시도해주세요."
        );
      }
    }
  }
});
</script>

<style></style>
