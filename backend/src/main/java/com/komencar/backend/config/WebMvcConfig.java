package com.komencar.backend.config;

import com.komencar.backend.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/", "/swagger-ui.html", "/webjars/**", "/v2/api-docs", "/configuration/security",
                        "/configuration/ui", "/swagger-resources/**", "/", "/csrf", "/error", "/favicon.ico", "/predict/picture",
                        "/user/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("*");
    }
}
