package com.example.common.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.dao.GenericHibernateDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Transactional
public abstract class GenericHibernateDaoImpl<T, ID >
        implements GenericHibernateDao<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    protected GenericHibernateDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(
                entityManager.contains(entity)
                        ? entity
                        : entityManager.merge(entity));
    }

    @Override
    public void deleteById(ID id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(
                entityManager.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {

        String jpql =
                "from " + entityClass.getSimpleName();

        return entityManager
                .createQuery(jpql, entityClass)
                .getResultList();
    }

    @Override
    public List<T> findAll(int page, int size) {

        String jpql =
                "from " + entityClass.getSimpleName();

        TypedQuery<T> query =
                entityManager.createQuery(jpql, entityClass);

        query.setFirstResult(page * size);
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public long count() {

        String jpql =
                "select count(e) from "
                        + entityClass.getSimpleName()
                        + " e";

        return entityManager
                .createQuery(jpql, Long.class)
                .getSingleResult();
    }

    @Override
    public boolean exists(ID id) {
        return findById(id).isPresent();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public void clear() {
        entityManager.clear();
    }
}