package com.gkfcsolution.springbootbankingapp.service;

import com.gkfcsolution.springbootbankingapp.dto.AccountDto;
import com.gkfcsolution.springbootbankingapp.entity.Account;

/**
 * Created on 2025 at 13:03
 * File: null.java
 * Project: springboot-banking-app
 *
 * @author Frank GUEKENG
 * @date 10/12/2025
 * @time 13:03
 */
public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
}
