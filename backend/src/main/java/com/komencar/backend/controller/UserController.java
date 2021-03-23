package com.komencar.backend.controller;

import com.komencar.backend.model.User;
import com.komencar.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public User join(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        boolean result = false;

        User searchedUser  = userRepository.findByUsername(user.getU_email());
        result = searchedUser.getU_password().equals(user.getU_password());

        return result;
    }
}