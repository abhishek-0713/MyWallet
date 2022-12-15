package com.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywallet.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
