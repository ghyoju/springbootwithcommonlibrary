package com.example.common.service;

import java.util.List;

public interface GenericHibernateService<T, ID > {

    T create(T entity);

    T update(T entity);

    void delete(ID id);

    T get(ID id);

    List<T> getAll();

    List<T> getAll(int page, int size);

    long count();

    boolean exists(ID id);
}