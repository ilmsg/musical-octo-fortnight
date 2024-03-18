package com.ilmsg.auth01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilmsg.auth01.model.MyUser;
import com.ilmsg.auth01.repository.MyUserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegistrationController {
    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String getRegisterHome() {
        return "home";
    }

    @PostMapping("/user")
    public MyUser createUser(@RequestBody() MyUser user) {
        log.info("username:" + user.getUsername());
        log.info("password:" + user.getPassword());
        log.info("role:" + user.getRole());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myUserRepository.save(user);
    }
}