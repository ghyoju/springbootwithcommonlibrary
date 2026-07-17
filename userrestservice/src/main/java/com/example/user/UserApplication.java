package com.example.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.user.entity.UserEntity;
import com.example.user.repository.UserRepository;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@Bean
    CommandLineRunner initData(UserRepository userRepository) {
        return args -> {

            if (userRepository.count() == 0) {

                userRepository.save(new UserEntity(
                        1l,
                        "John Doe",
                        "john@example.com"));

                userRepository.save(new UserEntity(
                        2l,
                        "Jane Smith",
                        "jane@example.com"));

                userRepository.save(new UserEntity(
                        3l,
                        "Robert Johnson",
                        "robert@example.com"));

                userRepository.save(new UserEntity(
                        4l,
                        "Emily Davis",
                        "emily@example.com"));

                userRepository.save(new UserEntity(
                        5l,
                        "Michael Brown",
                        "michael@example.com"));
                
                userRepository.save(new UserEntity(
                        6l,
                        "James Ford",
                        "ford@example.com"));

                System.out.println("Sample users inserted.");
            }
        };
    }

}
