package com.gkfcsolution.springbootbankingapp.mapper;

import com.gkfcsolution.springbootbankingapp.dto.AccountDto;
import com.gkfcsolution.springbootbankingapp.entity.Account;

/**
 * Created on 2025 at 13:06
 * File: null.java
 * Project: springboot-banking-app
 *
 * @author Frank GUEKENG
 * @date 10/12/2025
 * @time 13:06
 */
public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {

        /*return Account.builder()
                .id(accountDto.getId())
                .accountHolderName(accountDto.getAccountHolderName())
                .balance(accountDto.getBalance())
                .build();*/
        return Account.builder()
                .id(accountDto.id())
                .accountHolderName(accountDto.accountHolderName())
                .balance(accountDto.balance())
                .build();
    }

    public static AccountDto mapToAccountDto(Account account) {
      /*  return AccountDto.builder()
                .id(account.getId())
                .accountHolderName(account.getAccountHolderName())
                .balance(account.getBalance())
                .build();  */
        return new AccountDto(
                account.getId(), account.getAccountHolderName(), account.getBalance()
        );
    }
}
