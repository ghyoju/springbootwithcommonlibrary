package com.example.common.dao;

import java.util.List;

public interface CommonDao {

    List<String> findByEmail(String email);

}