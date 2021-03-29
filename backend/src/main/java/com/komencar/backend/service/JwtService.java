package com.komencar.backend.service;

import com.komencar.backend.model.User;
import com.nimbusds.oauth2.sdk.token.RefreshToken;

import java.util.Map;

public interface JwtService {

    //	로그인 성공시 사용자 정보를 기반으로 JWTToken을 생성하여 반환.
    public String create(User user);

    //	전달 받은 토큰이 문제가 있다면 RuntimeException을 발생, 아니면 map 반환
    public Map<String, Object> getValidToken(String jwtToken);
}
