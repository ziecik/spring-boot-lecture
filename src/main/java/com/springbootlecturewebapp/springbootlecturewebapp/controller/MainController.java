package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, User user) {
        modelAndView.addObject(user);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/aboutus")
    public ModelAndView aboutus(ModelAndView modelAndView) {
        modelAndView.setViewName("aboutus");
        return modelAndView;
    }
}
