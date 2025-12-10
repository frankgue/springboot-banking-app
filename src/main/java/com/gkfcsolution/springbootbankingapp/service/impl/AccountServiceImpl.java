package com.gkfcsolution.springbootbankingapp.service.impl;

import com.gkfcsolution.springbootbankingapp.dto.AccountDto;
import com.gkfcsolution.springbootbankingapp.entity.Account;
import com.gkfcsolution.springbootbankingapp.exception.AccountException;
import com.gkfcsolution.springbootbankingapp.mapper.AccountMapper;
import com.gkfcsolution.springbootbankingapp.repository.AccountRepository;
import com.gkfcsolution.springbootbankingapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created on 2025 at 13:05
 * File: AccountServiceImpl.java.java
 * Project: springboot-banking-app
 *
 * @author Frank GUEKENG
 * @date 10/12/2025
 * @time 13:05
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        log.info(String.valueOf(accountDto));
        Account saveAccount = accountRepository.save(account);
        log.info(String.valueOf(saveAccount));
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exists"));
        log.info(String.valueOf(account));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long accountId, double amount) {
        Account selectedAccount = accountRepository.findById(accountId).orElseThrow(() -> new AccountException("Account does not exists"));
        double  newBalance = selectedAccount.getBalance() + amount;
        selectedAccount.setBalance(newBalance);
        Account updatedAccount = accountRepository.save(selectedAccount);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public AccountDto withDraw(Long accountId, double amount) {
        Account selectedAccount = accountRepository.findById(accountId).orElseThrow(() -> new AccountException("Account does not exists"));

        if (selectedAccount.getBalance() < amount){
            log.error("Insuffisant customer Balance");
            throw new RuntimeException("Insuffisant customer Balance");
        }
        double  newBalance = selectedAccount.getBalance() - amount;
        selectedAccount.setBalance(newBalance);
        Account updatedAccount = accountRepository.save(selectedAccount);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(AccountMapper::mapToAccountDto).toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exists"));
        accountRepository.delete(account);
    }
}
