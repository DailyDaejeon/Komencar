import axios from "axios";
import store from "@/store/index";

export function setInterceptors() {
  const instance = axios.create({
    baseURL: "https://j4b101.p.ssafy.io/api/"
 
  });
  instance.interceptors.request.use(
    config => {
      
      return config;
    },
    error => {
      console.error("request error : ", error);
      return Promise.reject(error.response);
    }
  );
  instance.interceptors.response.use(
    config => {
  
      return config;
    },
    error => {
      console.error("response error : ", error);
   
      return Promise.reject(error.response);
    }
  );
  return instance;
}
