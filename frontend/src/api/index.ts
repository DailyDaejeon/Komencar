import axios, { AxiosPromise } from "axios";

const api = {
  // 예시
  news: "https://openapi.naver.com/v1/search/news.json",
  shopping: "https://openapi.naver.com/v1/datalab/shopping/categories",
};


// 콘솔 보고 data type정리(예시)
export interface NewsItem {
  lastBuildDate: any;
  total: any;
  id: any;
  start: any;
  display: any;
  originallink: any;
  title: any;
  link: any;
  description: any;
  pubDate: any;
}

const config = {
  // baseURL:`${api.news}?query="제네시스"`,
  headers:{
    'content-type': 'application/x-www-form-urlencoded; charset=UTF-8',
    "X-Naver-Client-Id": "HvQtg9CEBo2N_os9ug3_",
    "X-Naver-Client-Secret": "ePuJps7L6g"
  }
}

function fetchNews(): AxiosPromise<NewsItem[]> {
  return axios.get(`${api.news}?query="제네시스"`,config);
}


// function fetchUser(id: any) {
//   const url = `${api.user}${id}.json`;
//   return axios.get(url);
// }


export { fetchNews };
