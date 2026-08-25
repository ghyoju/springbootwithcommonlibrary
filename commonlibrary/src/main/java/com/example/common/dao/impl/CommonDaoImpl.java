package com.example.common.dao.impl;


import org.springframework.stereotype.Repository;

import com.example.common.dao.CommonDao;

import java.util.List;

import org.hibernate.Session;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CommonDaoImpl implements CommonDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<String> findByEmail(String email) {

        return entityManager.unwrap(Session.class).createNativeQuery(
                        "select USERNAME from COMMON_USER where EMAIL=:EMAIL",
                        String.class)
                .setParameter("EMAIL", email)
                .getResultList();
    }


}