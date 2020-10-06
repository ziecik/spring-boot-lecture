package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.ConfirmationTokenRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
class EmailSenderServicesTest {

    @Mock
    User user;
    @Mock
    UserRepository userRepository;
    @Mock
    ConfirmationTokenRepository confirmationTokenRepository;

    EmailSenderService emailSenderService;
    @Mock
    JavaMailSender javaMailSender;


    @Test
    public void sendEmail() {
        emailSenderService = new EmailSenderService(javaMailSender);
        user.setEmail("jaroslaw.ziecik@gmail.com");
         ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");

            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);
    }
}