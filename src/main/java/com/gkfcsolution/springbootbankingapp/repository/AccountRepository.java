package com.gkfcsolution.springbootbankingapp.repository;

import com.gkfcsolution.springbootbankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2025 at 13:01
 * File: null.java
 * Project: springboot-banking-app
 *
 * @author Frank GUEKENG
 * @date 10/12/2025
 * @time 13:01
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
