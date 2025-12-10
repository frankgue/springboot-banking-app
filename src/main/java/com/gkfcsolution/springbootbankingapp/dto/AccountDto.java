package com.gkfcsolution.springbootbankingapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 13:04
 * File: null.java
 * Project: springboot-banking-app
 *
 * @author Frank GUEKENG
 * @date 10/12/2025
 * @time 13:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
