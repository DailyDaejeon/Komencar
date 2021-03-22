const state = {
  // 예시
  // news: [] as NewsItem[]
};

// node_modules/vuex/types/vue.d.ts 삭제

type RootState = typeof state;

export { state, RootState };
