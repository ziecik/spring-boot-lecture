package com.springbootlecturewebapp.springbootlecturewebapp.repositories;

import com.springbootlecturewebapp.springbootlecturewebapp.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
