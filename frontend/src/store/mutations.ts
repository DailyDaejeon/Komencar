import { RootState } from "./state";
import jwtDecode from "jwt-decode";
import { logoutUser } from "@/api/index";

enum MutationTypes {
  SET_TOKEN = "SET_TOKEN",
  LOGOUT = "LOGOUT"
}

const mutations = {
  [MutationTypes.SET_TOKEN](state: RootState, token: any) {
    state.token = token;
    sessionStorage.setItem("auth-token", token);
    state.isLogin = true;
    state.userInfo = jwtDecode(token);
  },
  async [MutationTypes.LOGOUT](state: RootState) {
    await logoutUser();
    state.token = "";
    state.isLogin = false;
    sessionStorage.clear();
  }
};

type Mutations = typeof mutations;

export { MutationTypes, mutations, Mutations };
