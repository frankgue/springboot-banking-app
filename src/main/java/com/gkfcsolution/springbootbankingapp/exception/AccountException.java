package com.gkfcsolution.springbootbankingapp.exception;

/**
 * Created on 2025 at 14:26
 * File: null.java
 * Project: springboot-banking-app
 *
 * @author Frank GUEKENG
 * @date 10/12/2025
 * @time 14:26
 */
public class AccountException extends RuntimeException{
    public AccountException(String message){
        super(message);
    }
}
