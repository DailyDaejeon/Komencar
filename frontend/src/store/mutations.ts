// import { RootState } from "./state";

enum MutationTypes {
  // 예시
  // SET_NEWS = "SET_NEWS"
}

const mutations = {
  // 예시
  // [MutationTypes.SET_NEWS](state: RootState, news: NewsItem[]) {
  //   state.news = news;
  // }
};

type Mutations = typeof mutations;

export { MutationTypes, mutations, Mutations };
