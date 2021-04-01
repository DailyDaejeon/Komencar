package com.komencar.backend.interceptor;


import com.komencar.backend.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtService jwtService;

    public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info(request.getMethod() + " : " + request.getServletPath());

        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        String jwtToken = request.getHeader("auth-token");

        if(jwtToken != null && jwtToken.length() > 0){

            jwtService.getValidToken(jwtToken);

            return true;
        }

        else {
            throw new RuntimeException("인증 토큰이 없습니다.");
        }

    }
}
