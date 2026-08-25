package com.example.common.dao;

import java.util.List;

public interface UserDao {

    List<String> findByEmail(String email);

}