import { AxiosPromise } from "axios";
import { setInterceptors } from "@/api/instance/intercepter.js";

export interface UserInfo {
  u_email: string;
  u_name: string;
}

export interface ModelItem {
  m_id: number;
  m_manufacturer: string;
  m_name: string;
  m_price: string;
  m_effciency: number;
}

export interface NewsItem {
  title: string;
  originallink: string;
  link: string;
  description: string;
  pubDate: string;
}

export interface ShopItem {
  title: string;
  link: string;
  image: string;
  lprice: string;
  hprice: string;
  mallName: string;
}

const instance = setInterceptors();
// member api
function loginUser(): AxiosPromise<any[]> {
  return instance.post(`user/login`);
}

function logoutUser(): AxiosPromise<any[]> {
  return instance.post(`user/logout`);
}

function deleteUser(): AxiosPromise<any[]> {
  return instance.delete(`user/delete`);
}

function fetchUser(): AxiosPromise<any[]> {
  return instance.get(`user/info`);
}

// subscribe api
function addCar(modelId: number): AxiosPromise<any[]> {
  return instance.post(`mycar/add`, {
    m_id: modelId
  });
}

function deleteCar(modelId: number): AxiosPromise<any[]> {
  return instance.delete(`mycar/delte`, {
    params: {
      m_id: modelId
    }
  });
}

function fetchCars(): AxiosPromise<any[]> {
  return instance.get(`mycar/list`);
}

// model api
function fetchModel(modelId: number): AxiosPromise<any[]> {
  return instance.get(`model`, {
    params: {
      m_id: modelId
    }
  });
}

// etc
function fetchNews(words: string): AxiosPromise<any[]> {
  return instance.get(`news/${words}`, {
    params: { m_name: words }
  });
}

function fetchShops(words: string): AxiosPromise<any[]> {
  return instance.get(`shop/${words}`, {
    params: { m_name: words }
  });
}

export {
  loginUser,
  logoutUser,
  deleteUser,
  fetchUser,
  addCar,
  deleteCar,
  fetchCars,
  fetchModel,
  fetchNews,
  fetchShops
};
