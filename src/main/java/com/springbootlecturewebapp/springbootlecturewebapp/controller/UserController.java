package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/admin/byEmail")
    public ResponseEntity<User> byEmail() {
        return new ResponseEntity<>(userService.findByEmail("rabi@wp.pl"), HttpStatus.OK);
    }

    @GetMapping("/admin/users")
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public ModelAndView getUserDetails(ModelAndView modelAndView, @PathVariable Long id) {
        User user = userRepository.findOneById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-details");
        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView profile(ModelAndView modelAndView) {
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
