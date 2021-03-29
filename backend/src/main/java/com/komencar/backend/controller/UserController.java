package com.komencar.backend.controller;

import com.komencar.backend.model.User;
import com.komencar.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public User join(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/login")
    public User login(@AuthenticationPrincipal OAuth2User user) {
        String u_email = user.getAttribute("email");

        User searchedUser  = userRepository.findByUserEmail(u_email);

        return searchedUser;
    }

    @GetMapping("/test")
    public int test() {
        int result = (int) userRepository.count();
        return result;
    }

}