import axios, { AxiosInstance } from "axios";

// npm i @types/axios -D 설치

const APP_BASE_URI = "";
const options = {};

function create(url: string, options = {}): AxiosInstance {
  const instance = axios.create(Object.assign({ baseURL: url }, options));
  return instance;
}

function createWithAuth(url: string, options = {}) {
  const instance = axios.create(Object.assign({ baseURL: url }, options));
  return instance;
}

// 예시
// auth 필요없는 경우
// const news = create(`${APP_BASE_URI}news/`);
// auth 필요한 경우
// const user = createWithAuth(`${APP_BASE_URI}user/`, options);

// export { news, user };
