package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/")
    public String hello() {
        return (
                    "<h1>Welcome</h1>"
                );
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
        return (
                "<h1>Welcome user: " + authentication.getName() + "</h1>"
        );
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication) {
        return (
                "<h1>Welcome admin: " + authentication.getName() + "</h1>"
        );
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, User user) {
        modelAndView.addObject(user);
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
