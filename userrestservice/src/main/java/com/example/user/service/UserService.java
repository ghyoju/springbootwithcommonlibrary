package com.example.user.service;


import com.example.common.service.GenericHibernateService;
import com.example.user.entity.UserEntity;

public interface UserService extends GenericHibernateService<UserEntity, Long> {

	UserEntity findByEmail(String email);

}