package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void findByUsernameTest() {
        User user = new User();
        user.setUsername("koza");
        user.setEmail("koza@wp.pl");
        user.setFirstName("Paweł");
        user.setLastName("Koza");
        user.setPassword("dsafadsgadsgadsgadsg");

        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(user);

        assertEquals("koza", userService.findByUsername("koza").getUsername());
        assertEquals("koza@wp.pl", userService.findByUsername("koza").getEmail());
        assertEquals("Paweł", userService.findByUsername("koza").getFirstName());
        assertEquals("Koza", userService.findByUsername("koza").getLastName());
        assertEquals(null, userService.findByUsername("koza").getPassword());
    }
}