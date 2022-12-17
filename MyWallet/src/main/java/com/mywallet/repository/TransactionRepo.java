package com.mywallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywallet.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	
}
