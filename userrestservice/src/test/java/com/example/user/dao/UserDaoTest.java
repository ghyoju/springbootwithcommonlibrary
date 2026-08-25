package com.example.user.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.entity.UserEntity;


@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;
    
    @Test
    void shouldGetUsersFindAll() {

    	 List<UserEntity> users =
                userDao.findAll();

        assertNotNull(users);
        System.out.println("Users: " + users);        
    }

    @Test
    void shouldGetUsersUsingNativeQueryUserService() {

    	 Optional<UserEntity> optionalUser =
                userDao.findByEmail("jane@example.com");

        assertNotNull(optionalUser);
        UserEntity  userEntity = optionalUser.get();
        assertEquals("Jane Smith", userEntity.getName());
        System.out.println("First User Name: " + userEntity.getName());        
    }
}