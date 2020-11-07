package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        hidePassword(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        hidePassword(user);
        return user;
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            hidePassword(user);
        }
        return users;
    }

    private void hidePassword(User user) {
        user.setPassword(null);
    }
}
