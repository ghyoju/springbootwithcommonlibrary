package com.example.user.dao;

import com.example.common.dao.GenericHibernateDao;
import com.example.user.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends GenericHibernateDao<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}