import { ActionContext } from "vuex";
import { Mutations, MutationTypes } from "./mutations";
import { RootState } from "./state";
import {
 fetchLatest,
  fetchPriceCompare,
  fetchSizeCompare
} from "@/api/index";

enum ActionTypes {
 
  FETCH_LATEST = "FETCH_LATEST",
  SIMILAR_PRICE = "SIMILAR_PRICE",
  SAME_SEGMENT = "SAME_SEGMENT"
}

type MyActionContext = {
  commit<K extends keyof Mutations>(
    key: K,
    payload: Parameters<Mutations[K]>[1]
  ): ReturnType<Mutations[K]>;
} & Omit<ActionContext<RootState, RootState>, "commit">;

const actions = {
  async [ActionTypes.FETCH_LATEST](context: MyActionContext, payload?: number) {
    const { data } = await fetchLatest(payload);
    if (data) {
      context.commit(MutationTypes.LATEST_MODEL, data);
    } else {
      console.log("LATEST_MODEL ERROR");
    }
    return data;
  },
  async [ActionTypes.SIMILAR_PRICE](
    context: MyActionContext,
    payload?: number
  ) {
    const { data } = await fetchPriceCompare(payload);
    if (data) {
      context.commit(MutationTypes.SIMILAR_MODEL, data);
    } else {
      console.log("SIMILAR_MODEL ERROR");
    }
    return data;
  },
  async [ActionTypes.SAME_SEGMENT](context: MyActionContext, payload?: number) {
    const { data } = await fetchSizeCompare(payload);
    if (data) {
      context.commit(MutationTypes.SAME_SEGMENT_MODEL, data);
    } else {
      console.log("SAME_SEGMENT_MODEL ERROR");
    }
    return data;
  }
};

type Actions = typeof actions;

export { ActionTypes, actions, Actions };
