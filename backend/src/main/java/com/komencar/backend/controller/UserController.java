package com.komencar.backend.controller;

import com.komencar.backend.model.User;
import com.komencar.backend.repository.UserRepository;
import com.komencar.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/login")
    public User login(@AuthenticationPrincipal OAuth2User user, HttpServletResponse response) {
        String u_email = user.getAttribute("email");
        String u_name = user.getAttribute("name");

        User searchedUser  = userRepository.findByUserEmail(u_email);

        // 만약에 회원가입 되어 있지 않는 아이디라면
        if(searchedUser == null) {
            User insertUser = new User(u_email, u_name);
            userRepository.save(insertUser);
            searchedUser = insertUser;
        }

        String jwtToken = jwtService.create(searchedUser);
        response.setHeader("auth-token", jwtToken);

        return searchedUser;
    }

    @GetMapping("/test")
    public int test() {
        int result = (int) userRepository.count();
        return result;
    }

}