import axios, { AxiosPromise } from "axios";
import { setInterceptors } from "@/api/instance/intercepter.js";

export interface ModelItem {
  id: number;
  manufacturer: string;
  modelDetailList: ModelDetail[];
  name: string;
  segment: any;
}

export interface ModelDetail {
  effciency: number;
  exhaust: number;
  fuel: object;
  id: number;
  max_person: number;
  name: string;
  optionList: ModelOptionItem[];
}

export interface ModelOptionItem {
  id: number;
  name: string;
  price: number;
}

export interface NewsItem {
  description: string;
  link: string;
  originallink: string;
  pubDate: string;
  title: string;
}

export interface ShopItem {
  hprice: string;
  image: string;
  link: string;
  lprice: string;
  mallName: string;
  title: string;
}

const instance = setInterceptors();

// model api
function searchModelImg(imagePic: any): AxiosPromise<string> {
  return axios.post(`https://j4b101.p.ssafy.io/predict/picture`, imagePic, {
    headers: {
      "Content-Type": "multipart/form-data"
      // "Access-Control-Allow-Origin": "*"
    }
  });
}

function findModelId(modelName: string): AxiosPromise<ModelItem> {
  return instance.get(`model/search/${modelName}`);
}

function fetchAllCars(): AxiosPromise<any[]> {
  return instance.get(`model/all_list`);
}

function fetchAllOptions(
  modelDetailId: number
): AxiosPromise<ModelOptionItem[]> {
  return instance.get(`model/option_list`, {
    params: {
      md_id: modelDetailId
    }
  });
}

function fetchLatest(modelId: number): AxiosPromise<ModelDetail> {
  return instance.get(`model/latest_model`, {
    params: {
      m_id: modelId
    }
  });
}

function searchCar(keyWord: string): AxiosPromise<ModelItem[]> {
  return instance.get(`model/search_list`, {
    params: {
      keyword: keyWord
    }
  });
}

function fetchModel(modelDetailId: number): AxiosPromise<any> {
  return instance.get(`model/info/${modelDetailId}`);
}

//가격 비교 api
function fetchPriceCompare(modelId: number): AxiosPromise<ModelItem[]> {
  return instance.get(`model/similar_price/${modelId}`);
}

//사이즈 비교 api
function fetchSizeCompare(modelId: number): AxiosPromise<ModelItem[]> {
  return instance.get(`model/same_segment/${modelId}`);
}

// etc
function fetchNews(words: string): AxiosPromise<NewsItem[]> {
  return instance.get(`news/${words}`);
}

function fetchShops(words: string): AxiosPromise<ShopItem[]> {
  return instance.get(`shop/${words}`);
}

export {
  findModelId,
  fetchAllCars,
  fetchAllOptions,
  fetchLatest,
  fetchModel,
  searchModelImg,
  searchCar,
  fetchNews,
  fetchShops,
  fetchPriceCompare,
  fetchSizeCompare
};
