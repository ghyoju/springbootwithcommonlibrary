package com.example.common.dao;

import java.util.List;
import java.util.Optional;

public interface GenericHibernateDao<T, ID > {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    List<T> findAll(int page, int size);

    long count();

    boolean exists(ID id);

    void flush();

    void clear();
}