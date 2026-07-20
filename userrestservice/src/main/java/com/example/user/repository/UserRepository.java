package com.example.user.repository;


import org.springframework.stereotype.Repository;

import com.example.common.repository.GenericRepository;
import com.example.user.entity.UserEntity;


@Repository
public interface UserRepository extends GenericRepository<UserEntity, Long> {
	
	boolean existsByEmail(String email);
	
}
