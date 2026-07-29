package com.example.user.service.impl;


import com.example.common.service.impl.GenericHibernateServiceImpl;
import com.example.user.dao.UserDao;
import com.example.user.entity.UserEntity;
import com.example.user.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl
        extends GenericHibernateServiceImpl<UserEntity, Long>
        implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public UserEntity findByEmail(String email) {

        return userDao.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
}