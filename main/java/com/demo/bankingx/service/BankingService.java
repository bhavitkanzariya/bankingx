package com.demo.bankingx.service;

import java.math.BigDecimal;

import com.demo.bankingx.entity.CurrentAccount;
import com.demo.bankingx.entity.Customer;
import com.demo.bankingx.entity.SavingsAccount;

import antlr.collections.List;

public interface BankingService {
	Customer createCustomer(Customer customer);

	CurrentAccount depositToCurrentAccount(Long customerId, BigDecimal amount);

	CurrentAccount withdrawFromCurrentAccount(Long customerId, BigDecimal amount);

	CurrentAccount transferBetweenCurrentAccounts(Long sourceCustomerId, Long targetCustomerId, BigDecimal amount);

	SavingsAccount depositToSavingsAccount(Long customerId, BigDecimal amount);

	List getAllTransactions(Long customerId);
}
