package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin/byEmail")
    public User byEmail() {
        User user = userRepository.findByEmail("rabi@wp.pl");
        return user;
    }

    @GetMapping("/admin/users")
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/user/{id}")
    public ModelAndView getUserDetails(ModelAndView modelAndView, @PathVariable Long id) {
        User user = userRepository.findOneById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-details");
        return modelAndView;
    }
}
