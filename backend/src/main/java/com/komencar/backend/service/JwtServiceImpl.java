package com.komencar.backend.service;

import com.komencar.backend.model.User;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


@Service
public class JwtServiceImpl implements JwtService{

    public static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    private String signature = "KOMENCAR";

    // 토큰 만료 시간 설정
    private Long expireMin = 60L;
    private Date expired_token_date = new Date(System.currentTimeMillis() + (1000 * 60 * expireMin));

    @Override
    public String create(User user) {

        // JWT Token = Header + Payload + Signature
        JwtBuilder jwtBuilder = Jwts.builder();


        // Header 설정
        jwtBuilder.setHeaderParam("typ", "JWT"); // 토큰의 타입으로 고정 값.

        //	Payload 설정
        jwtBuilder
                .setSubject("KOMENCAR") // 토큰의 제목 설정
                .setExpiration(expired_token_date)
                .claim("u_email", user.getU_email())
                .claim("u_name", user.getU_name())
                .claim("token_expired", expired_token_date);

        // signature 설정
        jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());


        // 마지막 직렬화 처리
        String jwt = jwtBuilder.compact();

        // logger.info("jwt : {}", jwt);

        return jwt;
    }

    @Override
    public Map<String, Object> getValidToken(String jwtToken) {

        Jws<Claims> claims = null;

        // 예외가 발생하지 않으면 OK
        try {
            claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwtToken);

            Long expired_time = Long.parseLong(claims.getBody().get("token_expired").toString());
            if(expired_time < System.currentTimeMillis()) {
                throw new RuntimeException();
            }
        }

        catch (SignatureException e) {
            logger.info("Invalid JWT signature");
            throw new RuntimeException();
        }

        return claims.getBody();
    }
}
