package com.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywallet.model.BankAccount;

public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

}
