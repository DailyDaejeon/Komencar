import { RootState } from "./state";
import jwtDecode from 'jwt-decode'

enum MutationTypes {
  // 예시
  // SET_NEWS = "SET_NEWS",
  SET_TOKEN = "SET_TOKEN",
  LOGOUT = "LOGOUT",
}

const mutations = {
  // 예시
  // [MutationTypes.SET_NEWS](state: RootState, news: NewsItem[]) {
  //   state.news = news;
  // }
  [MutationTypes.SET_TOKEN](state: RootState, token:any) {
    state.token = token
    sessionStorage.setItem('auth-token', token)
    state.isLogin = true
    state.userInfo = jwtDecode(token)
  },
  [MutationTypes.LOGOUT](state:RootState) {
    state.token = ''
    state.isLogin = false
    // if (this.$gAuth != undefined) {
    //     this.$gAuth.signOut();
    // }
    sessionStorage.clear()
  }
};

type Mutations = typeof mutations;

export { MutationTypes, mutations, Mutations };
