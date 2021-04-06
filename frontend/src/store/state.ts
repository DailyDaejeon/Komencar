import jwtDecode from "jwt-decode";

const state = {
  // 예시
  // news: [] as NewsItem[]
  token: sessionStorage.getItem("auth-token") || null,
  isLogin: sessionStorage.getItem("auth-token") === null ? false : true,
  userInfo:
    sessionStorage.getItem("auth-token") === null
      ? {}
      : jwtDecode(sessionStorage.getItem("auth-token")),
  modelInfo: JSON.parse(sessionStorage.getItem("model-info")) || {},
  latestModel: JSON.parse(sessionStorage.getItem("latest-model")) || {},
  modelName: JSON.parse(sessionStorage.getItem("model_name")) || "",
  similarModel: JSON.parse(sessionStorage.getItem("similar_model")) || [],
  sameSegment: JSON.parse(sessionStorage.getItem("same_segment")) || []
};

// node_modules/vuex/types/vue.d.ts 삭제

type RootState = typeof state;

export { state, RootState };
