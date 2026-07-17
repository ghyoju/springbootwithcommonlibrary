package com.example.common.service;

import com.example.common.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class DataService<T, ID extends Serializable> {

    @Autowired
    private GenericRepository<T, ID> repository;

    public List<T> getAllData() {
        return repository.findAll();
    }

    public Optional<T> getDataById(ID id) {
        return repository.findById(id);
    }

    public void saveData(T entity) {
        repository.save(entity);
    }
}
