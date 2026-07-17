package com.example.account.repository;


import org.springframework.stereotype.Repository;

import com.example.account.entity.AccountEntity;
import com.example.common.repository.GenericRepository;


@Repository
public interface AccountRepository extends GenericRepository<AccountEntity, Long> {
}
