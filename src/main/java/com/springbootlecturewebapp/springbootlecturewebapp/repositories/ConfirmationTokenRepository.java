package com.springbootlecturewebapp.springbootlecturewebapp.repositories;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
