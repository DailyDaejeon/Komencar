package com.komencar.backend.controller;

import com.komencar.backend.model.News;
import com.komencar.backend.model.Shop;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@RestController
public class NewsController {

    @GetMapping("/news/{m_name}")
    public ArrayList<News> selectNewsAll(@PathVariable String m_name) {
        String clientId = "skOTY9eqFKM7wQ9zm_C5";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "c7AEkbfl8k";//애플리케이션 클라이언트 시크릿값";
        ArrayList<News> news = new ArrayList<>();
        try {
            String text = URLEncoder.encode(m_name, "UTF-8"); //검색어";
            String apiURL = "https://openapi.naver.com/v1/search/news.json?query="+ text + "&display=10&start=1&sort=date"; // 뉴스의 json 결과

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            JSONParser jsonParser = new JSONParser();
            StringBuilder sb = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            JSONObject jsonObj = (JSONObject) jsonParser.parse(String.valueOf(sb));
            JSONArray itemArray = (JSONArray) jsonObj.get("items");
            for (int i = 0; i < itemArray.size(); i++) {
                JSONObject tempObj = (JSONObject) itemArray.get(i);
                news.add(new News(tempObj.get("title").toString(), tempObj.get("description").toString(),
                        tempObj.get("pubDate").toString(), tempObj.get("originallink").toString(),
                        tempObj.get("link").toString()));
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return news;
    }

}
