package com.example.common.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.common.config.CommonConfig;


@SpringJUnitConfig(classes = CommonConfig.class)
class CommonDaoTest {

    @Autowired
    private CommonDao userDao;

    @Test
    void shouldGetUsersUsingNativeQuery() {

        List<String> userNames =
                userDao.findByEmail("test@example.com");

        assertNotNull(userNames);
        assertFalse(userNames.isEmpty());
        assertEquals(1, userNames.size());
        String  firstUserName = userNames.get(0);
        assertEquals("testuser", firstUserName);
        System.out.println("First User Name: " + userNames);
        
    }
}