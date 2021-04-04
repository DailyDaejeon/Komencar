<template>
  <div class="search">
    <div class="search__div">
      <h1 class="search__text">Search</h1>
      <div class="search__container">
        <form
          autocomplete="off"
          @submit.prevent="goSearch"
          class="search__form"
        >
          <div class="search__finder">
            <div class="search__finder__outer">
              <div class="search__finder__inner">
                <div class="search__finder__icon" ref="icon"></div>
                <input
                  class="search__finder__input"
                  @focus="addActiveClass"
                  @blur="removeActiveClass"
                  type="text"
                  name="q"
                />
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    <!-- 검색한 결과가 v-for로 돌려 보이게 만듦 -->
    <div class="search__result" v-if="searchResult">
      <span
        >'{{ keyword }}'에 대한 검사 결과가 '전체'에서
        {{ searchResult.length }}건이 검색되었습니다.</span
      >
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
      }
    };
  },
  methods: {
    goSearch() {
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
      searchCar(this.keyword).then(res => {
        console.log(res);
        this.searchResult = res.data;
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
