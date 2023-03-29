package com.demo.bankingx.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bankingx.entity.CurrentAccount;
import com.demo.bankingx.entity.Customer;
import com.demo.bankingx.service.BankingService;

@RestController
@RequestMapping("/api/v1/customers")
public class BankingController {
	@Autowired
	private BankingService bankingService;

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer createdCustomer = bankingService.createCustomer(customer);
		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	}

	@PostMapping("/{customerId}/current-account/deposit")
	public ResponseEntity<CurrentAccount> depositToCurrentAccount(@PathVariable Long customerId,
			@RequestParam BigDecimal amount) {
		CurrentAccount currentAcc = bankingService.depositToCurrentAccount(customerId, amount);
		return new ResponseEntity<>(currentAcc, HttpStatus.CREATED);
	}
}
