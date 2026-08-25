package com.example.user.dao.impl;


import org.springframework.stereotype.Repository;

import com.example.common.dao.impl.GenericHibernateDaoImpl;
import com.example.user.dao.UserDao;
import com.example.user.entity.UserEntity;

import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericHibernateDaoImpl<UserEntity, Long>
        implements UserDao {

    public UserDaoImpl() {
        super(UserEntity.class);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {

        return getSession()
                .createSelectionQuery(
                        "from UserEntity where email=:email",
                        UserEntity.class)
                .setParameter("email", email)
                .uniqueResultOptional();
    }
}