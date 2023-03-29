package com.demo.bankingx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bankingx.entity.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long>{

	CurrentAccount findByCustomer(Long customerId);

}
