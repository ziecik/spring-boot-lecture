package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    Optional<User> findOneById(Long id);
    List<User> findAll();
}
