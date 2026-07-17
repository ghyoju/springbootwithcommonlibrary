package com.example.account;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.account.entity.AccountEntity;
import com.example.account.repository.AccountRepository;


@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
    CommandLineRunner initData(AccountRepository userRepository) {
        return args -> {

            if (userRepository.count() == 0) {

                userRepository.save(new AccountEntity(
                        1l,
                        "John Doe Account",
                        new BigDecimal("100000")));

                userRepository.save(new AccountEntity(
                        2l,
                        "Jane Smith",
                        new BigDecimal("50000")));

                userRepository.save(new AccountEntity(
                        3l,
                        "Robert Johnson",
                        new BigDecimal("10000")));

                userRepository.save(new AccountEntity(
                        4l,
                        "Emily Davis",
                        new BigDecimal("100000")));

                userRepository.save(new AccountEntity(
                        5l,
                        "Michael Brown",
                        new BigDecimal("100000")));
                
                userRepository.save(new AccountEntity(
                        6l,
                        "James Ford",
                        new BigDecimal("500000000")));

                System.out.println("Sample users inserted.");
            }
        };
    }

}
