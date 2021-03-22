import { ActionContext } from "vuex";
import { Mutations, MutationTypes } from "./mutations";
import { RootState } from "./state";

enum ActionTypes {
  // 예시
  // FETCH_NEWS = "FETCH_NEWS"

}

type MyActionContext = {
  commit<K extends keyof Mutations>(
    key: K,
    payload: Parameters<Mutations[K]>[1]
  ): ReturnType<Mutations[K]>;
} & Omit<ActionContext<RootState, RootState>, "commit">;

const actions = {
  // 예시
  // async [ActionTypes.FETCH_NEWS](context: MyActionContext, payload?: any) {
  //   const { data } = await fetchNews();
  //   context.commit(MutationTypes.SET_NEWS, data);
  //   return data;
  // }
};

type Actions = typeof actions;

export { ActionTypes, actions, Actions };
