package com.demo.bankingx.service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankingx.Repository.CurrentAccountRepository;
import com.demo.bankingx.Repository.CustomerRepository;
import com.demo.bankingx.entity.CurrentAccount;
import com.demo.bankingx.entity.Customer;
import com.demo.bankingx.entity.SavingsAccount;

import antlr.collections.List;

@Service
public class BankingServiceImpl implements BankingService {

	@Autowired
	private static CustomerRepository customerRepository;

	@Autowired
	private static CurrentAccountRepository currentAccountRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer customerEntity = new Customer();
		customerRepository.save(customerEntity);
		return null;
	}

	@Override
	public CurrentAccount depositToCurrentAccount(Long customerId, BigDecimal amount) {

		Optional<Customer> customerEntityOpt = customerRepository.findById(customerId);
		if (Objects.nonNull(customerEntityOpt)) {
			Customer customerEntity = customerEntityOpt.get();
			CurrentAccount currentAccountEntity = currentAccountRepository.findByCustomer(customerId);
			if (Objects.nonNull(currentAccountEntity)) {
				BigDecimal prevBalance = currentAccountEntity.getBalance();
				currentAccountEntity.setBalance(prevBalance.add(amount));
				currentAccountRepository.save(currentAccountEntity);
			} else {
				CurrentAccount currentAccount = new CurrentAccount();
				BigDecimal bonus = new BigDecimal(500);
				currentAccount.setBalance(amount.add(bonus));
				currentAccount.setCustomer(customerEntity);
				currentAccountRepository.save(currentAccount);
			}
		}
		return null;
	}

	@Override
	public CurrentAccount withdrawFromCurrentAccount(Long customerId, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrentAccount transferBetweenCurrentAccounts(Long sourceCustomerId, Long targetCustomerId,
			BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavingsAccount depositToSavingsAccount(Long customerId, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllTransactions(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
