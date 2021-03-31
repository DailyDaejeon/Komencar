package com.komencar.backend.controller;

import com.komencar.backend.interceptor.JwtInterceptor;
import com.komencar.backend.model.User;
import com.komencar.backend.repository.UserRepository;
import com.komencar.backend.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/login")
    public OAuth2User login(@AuthenticationPrincipal OAuth2User user, HttpServletResponse response) {
        String u_email = user.getAttribute("email");
        String u_name = user.getAttribute("name");

        logger.info("u_email : " + u_email + ", u_name : " + u_name);

        User searchedUser  = userRepository.findByUserEmail(u_email);

        // 만약에 회원가입 되어 있지 않는 아이디라면
        if(searchedUser == null) {
            User insertUser = new User(u_email, u_name);
            userRepository.save(insertUser);
            searchedUser = insertUser;
        }

        String jwtToken = jwtService.create(searchedUser);
        response.setHeader("auth-token", jwtToken);

        return user;
    }

    @GetMapping("/login/callback")
    public void callback(@AuthenticationPrincipal OAuth2User user, HttpServletResponse response) {
        System.out.println(user.toString());
//        String u_email = request.getAttribute("email").toString();
//        String u_name = request.getAttribute("name").toString();
//
//        System.out.println(u_email + " " + u_name);
//
//        User searchedUser  = userRepository.findByUserEmail(u_email);
//
//        // 만약에 회원가입 되어 있지 않는 아이디라면
//        if(searchedUser == null) {
//            User insertUser = new User(u_email, u_name);
//            userRepository.save(insertUser);
//            searchedUser = insertUser;
//        }
//
//        String jwtToken = jwtService.create(searchedUser);
//        response.setHeader("auth-token", jwtToken);
//
//        return searchedUser;
    }

}