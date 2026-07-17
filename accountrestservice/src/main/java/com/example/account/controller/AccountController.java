package com.example.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.account.entity.AccountEntity;
import com.example.account.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Accounts", description = "Account Management APIs")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    @Operation(summary = "Get all accounts")
    public List<AccountEntity> getAllAccounts() {
        return accountService.getAllAcounts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get accountById")
    public AccountEntity getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id).get();
    }

    @PostMapping
    @Operation(summary = "Save account")
    public void saveAccount(@RequestBody AccountEntity account) {
        accountService.saveAccount(account);
    }
    
}
