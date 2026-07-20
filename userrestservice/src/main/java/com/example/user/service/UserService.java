package com.example.user.service;

import com.example.user.entity.UserEntity;
import com.example.user.exception.UserAlreadyExistsException;
import com.example.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
    	 Optional<UserEntity> userOptional = userRepository.findById(id);
         return userOptional.orElse(null);
    }

    public void saveUser(UserEntity user) {
    	if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
    }
    
}
