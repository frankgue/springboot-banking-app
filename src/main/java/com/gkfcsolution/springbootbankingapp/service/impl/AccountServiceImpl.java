package com.gkfcsolution.springbootbankingapp.service.impl;

import com.gkfcsolution.springbootbankingapp.dto.AccountDto;
import com.gkfcsolution.springbootbankingapp.entity.Account;
import com.gkfcsolution.springbootbankingapp.mapper.AccountMapper;
import com.gkfcsolution.springbootbankingapp.repository.AccountRepository;
import com.gkfcsolution.springbootbankingapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }
}
