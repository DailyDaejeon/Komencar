import axios from "axios";
import store from "@/store/index";

export function setInterceptors() {
  const instance = axios.create({
    baseURL: "http://j4b101.p.ssafy.io:8081/",
    // CORS 방지코드
    headers: {
      // Authorization: store.state.token
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json; charset = utf-8"
    }
  });
  instance.interceptors.request.use(
    config => {
      console.log("request config: ", config);
      // const token = store.state.token;
      // config.headers.Authorization = token;
      return config;
    },
    error => {
      console.log("request error : ", error);

      // const token = error.response.headers.authorization;
      // store.commit("SET_TOKEN", token);
      return Promise.reject(error.response);
    }
  );
  instance.interceptors.response.use(
    config => {
      console.log("response config: ", config);
      // const token = config.headers.authorization;
      // store.commit("SET_TOKEN", token);
      return config;
    },
    error => {
      console.log("response error : ", error);
      // const token = error.response.headers.authorization;
      // store.commit("SET_TOKEN", token);
      return Promise.reject(error.response);
    }
  );
  return instance;
}
