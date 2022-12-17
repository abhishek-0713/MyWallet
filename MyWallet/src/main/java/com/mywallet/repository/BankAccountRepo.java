package com.mywallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywallet.model.BankAccount;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

	
}
