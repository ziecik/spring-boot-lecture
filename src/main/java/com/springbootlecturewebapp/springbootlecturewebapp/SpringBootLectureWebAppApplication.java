package com.springbootlecturewebapp.springbootlecturewebapp;

import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringBootLectureWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLectureWebAppApplication.class, args);
	}

}
