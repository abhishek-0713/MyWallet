package com.mywallet.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywallet.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	public List<Transaction> findByTransactionType(String transactionType);
	
	public List<Transaction> findByTransactionDate(LocalDate transactionDate);
	
	public List<Transaction> findByTransactionBetweenDate(LocalDate from, LocalDate to);
	
	@Query(value = "from Transaction t INNER JOIN t.wallet w where w.walletId=?1")
	public List<Transaction> findByWalletId(Integer walletId);

}
