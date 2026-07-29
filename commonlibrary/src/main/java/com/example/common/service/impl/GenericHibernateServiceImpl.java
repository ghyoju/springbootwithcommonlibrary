package com.example.common.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.common.dao.GenericHibernateDao;
import com.example.common.service.GenericHibernateService;

@Transactional
public abstract class GenericHibernateServiceImpl<T, ID >
        implements GenericHibernateService<T, ID> {

    protected final GenericHibernateDao<T, ID> dao;

    protected GenericHibernateServiceImpl(
            GenericHibernateDao<T, ID> dao) {

        this.dao = dao;
    }

    @Override
    public T create(T entity) {
        return dao.save(entity);
    }

    @Override
    public T update(T entity) {
        return dao.update(entity);
    }

    @Override
    public void delete(ID id) {
        dao.deleteById(id);
    }

    @Override
    public T get(ID id) {
        return dao.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Entity not found"));
    }

    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

    @Override
    public List<T> getAll(int page, int size) {
        return dao.findAll(page, size);
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public boolean exists(ID id) {
        return dao.exists(id);
    }
}