package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/")
    public String hello() {
        return (
                    "<h1>Welcome</h1>"
                );
    }

    @RequestMapping("/user")
    public String user() {
        return (
                "<h1>Welcome user</h1>"
        );
    }

    @RequestMapping("/admin")
    public String admin() {
        return (
                "<h1>Welcome admin</h1>"
        );
    }
}
