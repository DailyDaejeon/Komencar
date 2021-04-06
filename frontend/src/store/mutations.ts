import { RootState } from "./state";
import jwtDecode from "jwt-decode";
import { logoutUser } from "@/api/index";

enum MutationTypes {
  SET_TOKEN = "SET_TOKEN",
  LOGOUT = "LOGOUT",
  MODEL_INFO = "MODEL_INFO",
  LATEST_MODEL = "LATEST_MODEL",
  MODEL_NAME = "MODEL_NAME",
  SIMILAR_MODEL = "SIMILAR_MODEL",
  SAME_SEGMENT_MODEL = "SAME_SEGMENT_MODEL"
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
  },
  async [MutationTypes.MODEL_INFO](state: RootState, modelInfo: any) {
    state.modelInfo = modelInfo;
    sessionStorage.setItem("model-info", JSON.stringify(modelInfo));
  },
  async [MutationTypes.LATEST_MODEL](state: RootState, modelInfo: any) {
    state.latestModel = modelInfo;
    sessionStorage.setItem("latest-model", JSON.stringify(modelInfo));
  },
  async [MutationTypes.MODEL_NAME](state: RootState, modelname: string) {
    state.modelName = modelname;
    sessionStorage.setItem("model_name", JSON.stringify(modelname));
  },
  async [MutationTypes.SIMILAR_MODEL](state: RootState, modelInfo: any) {
    state.modelName = modelInfo;
    sessionStorage.setItem("similar_model", JSON.stringify(modelInfo));
  },
  async [MutationTypes.SAME_SEGMENT_MODEL](state: RootState, modelInfo: any) {
    state.modelName = modelInfo;
    sessionStorage.setItem("same_segment", JSON.stringify(modelInfo));
  }
};

type Mutations = typeof mutations;

export { MutationTypes, mutations, Mutations };
