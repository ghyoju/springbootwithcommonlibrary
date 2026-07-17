package com.example.account.service;

import com.example.account.entity.AccountEntity;
import com.example.account.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountEntity> getAllAcounts() {
        return accountRepository.findAll();
    }

    public Optional<AccountEntity> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public void saveAccount(AccountEntity account) {
    	accountRepository.save(account);
    }
}
