package com.springbootlecturewebapp.springbootlecturewebapp.model.audit.config;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.Optional;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
@Transactional
public class AuditingConfig {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    class AuditorAwareImpl implements AuditorAware<String> {


        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null ||
                    !authentication.isAuthenticated() ||
                    authentication instanceof AnonymousAuthenticationToken) {
                return Optional.empty();
            }
            return Optional.of(authentication.getName());
        }
    }
}
