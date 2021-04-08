const state = {
   modelInfo: JSON.parse(sessionStorage.getItem("model-info")) || {},
  latestModel: JSON.parse(sessionStorage.getItem("latest-model")) || {},
  modelName: JSON.parse(sessionStorage.getItem("model_name")) || "",
  similarModel: JSON.parse(sessionStorage.getItem("similar_model")) || [],
  sameSegment: JSON.parse(sessionStorage.getItem("same_segment")) || []
};

// node_modules/vuex/types/vue.d.ts 삭제

type RootState = typeof state;

export { state, RootState };
