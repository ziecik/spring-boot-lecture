package com.springbootlecturewebapp.springbootlecturewebapp.repositories;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    UserRepository userRepository;
    @Mock
    User user;


    @Test
    void findByUsername() {
        user.setUsername("Stasiek");
        when(userRepository.findByUsername("Stasiek")).thenReturn(user);
        assertEquals(user, userRepository.findByUsername("Stasiek"));
    }

    @Test
    void findByEmail() {
        user.setEmail("ja@wp.pl");
        when(userRepository.findByEmail("ja@wp.pl")).thenReturn(user);
        assertEquals(user, userRepository.findByEmail("ja@wp.pl"));
    }


}