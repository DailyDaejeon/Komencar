<template>
  <div>
    <!-- <div class="search">
      <div class="search__div">
        <h1 class="search__text">Search</h1> -->
    <div class="search__container">
      <form autocomplete="off" @submit.prevent="goSearch" class="search__form">
        <div class="search__finder">
          <div class="search__finder__outer">
            <div class="search__finder__inner">
              <div class="search__finder__icon" ref="icon"></div>
              <input
                class="search__finder__input"
                placeholder="검색어를 입력해주세요."
                @focus="addActiveClass"
                @blur="removeActiveClass"
                type="text"
                name="q"
              />
            </div>
          </div>
        </div>
      </form>
      <!-- </div>
      </div> -->
    </div>
    <!-- 검색한 결과가 v-for로 돌려 보이게 만듦 -->
    <div class="search__result">
      <template v-if="searchResult[0]">
        <span class="search__result__typo"
          ><strong>
            '<span class="search__result__typo-blue"> {{ keyword }}</span
            >'에 대한 검사 결과가
            <span class="search__result__typo-blue"
              >'전체'에서 {{ searchItemCnts }}건</span
            >이 검색되었습니다.</strong
          ></span
        >
        <div
          v-for="(model, mindex) in searchResult"
          :key="mindex"
          class="search__result__div"
        >
          <h2 class="search__result__model">{{ model.name }}</h2>
          <div v-for="(search, index) in model.modelDetailList" :key="index">
            <img
              :src="getImg(search.name)"
              alt=""
              class="search__result__model__img"
            />
            <span>{{ search.name }}</span>
            <p>
              가격 :
              {{ search.optionList[0].price / 10000 }}만원~
              {{
                search.optionList[search.optionList.length - 1].price / 10000
              }}만원
            </p>
            <p v-if="search.effciency">연비 : {{ search.effciency }}</p>
            <p>
              엔진 : {{ search.fuel.name }}
              <span v-if="search.exhaust"> {{ search.exhaust }}cc</span>
            </p>
          </div>
          <hr />
        </div>
      </template>
      <template v-else>
        <span class="search__result__typo"
          ><strong>입력하신 '{{ keyword }}'에 대한 검색결과가 없습니다.</strong>
          <br />
          <span class="search__result__typo-small">
            입력하신 검색어의 철자가 정확한지 확인해 주세요. <br />
            검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 검색해 보세요.
          </span>
        </span>
      </template>
    </div>
  </div>
</template>
<script lang="ts">
import Vue from "vue";
import { searchCar } from "@/api/index";

export default Vue.extend({
  data() {
    return {
      keyword: {
        type: String
      },
      searchResult: {
        type: Array
      },
      isValid: {
        type: Boolean,
        default: false
      }
    };
  },
  computed: {
    searchItemCnts() {
      let length = 0;
      for (let i = 0; i < this.searchResult.length; i++) {
        length += this.searchResult[i].modelDetailList.length;
      }
      return length;
    }
  },
  methods: {
    getImg(mName) {
      //내가 찍은 차 이미지 받아오는 메소드
      let name = mName.split(" ");
      name = name.join("_");
      console.log(name, "이미지");
      return require(`@/assets/images/cars/${name}.jpg`);
    },
    async goSearch() {
      const input = document.querySelector(
        ".search__finder__input"
      ) as HTMLInputElement;
      const finder = document.querySelector(
        ".search__finder"
      ) as HTMLDivElement;
      finder.classList.add("processing");
      finder.classList.remove("active");
      input.disabled = true;
      this.keyword = input.value;
      console.log("KEYWORD : ", this.keyword);
      await searchCar(this.keyword).then(res => {
        console.log(res);
        this.searchResult = res.data;
        this.isValid = true;
        finder.classList.remove("processing");
        input.disabled = false;
        if (input.value.length > 0) {
          finder.classList.add("active");
        }
      });
    },
    addActiveClass() {
      const finder = document.querySelector(
        ".search__finder"
      ) as HTMLDivElement;
      finder.classList.add("active");
    },
    removeActiveClass() {
      const input = document.querySelector(
        ".search__finder__input"
      ) as HTMLInputElement;
      const finder = document.querySelector(
        ".search__finder"
      ) as HTMLDivElement;
      if (input.value.length === 0) {
        finder.classList.remove("active");
      }
    }
  }
});
</script>

<style></style>
