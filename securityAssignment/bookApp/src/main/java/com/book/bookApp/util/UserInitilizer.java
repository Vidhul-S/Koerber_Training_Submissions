package com.book.bookApp.util;

import com.book.bookApp.entities.User;
import com.book.bookApp.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserInitilizer {

    @Bean
    public CommandLineRunner initData(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepo.findByUsername("teacher").isEmpty()) {
                userRepo.save(new User(null, "teacher", passwordEncoder.encode("password"), Set.of("TEACHER")));
            }
            if (userRepo.findByUsername("student").isEmpty()) {
                userRepo.save(new User(null, "student", passwordEncoder.encode("password"), Set.of("STUDENT")));
            }
        };
    }
}
