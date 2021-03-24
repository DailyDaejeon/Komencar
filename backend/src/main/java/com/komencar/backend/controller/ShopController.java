package com.komencar.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
public class ShopController {
    @GetMapping("/shop/{m_name}")
    public void selectNewsAll(@PathVariable String m_name) {
        String clientId = "sjTv8tlDzsXL9gAUbqv_";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "n8SuPodTFM";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(m_name + "굿즈", "UTF-8"); //검색어";
            String apiURL = "https://openapi.naver.com/v1/search/shop.json?query="+ text + "&display=10&start=1&sort=date"; // 뉴스의 json 결과

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
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
