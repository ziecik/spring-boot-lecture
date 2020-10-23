package com.springbootlecturewebapp.springbootlecturewebapp.repositories;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findOneById(Long id);
}
