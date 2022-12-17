package com.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywallet.model.Transaction;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    public List<Transaction> findByTransactionDate(LocalDate transactionDate);

    public List<Transaction> findByTransactionDateBetween(LocalDate from, LocalDate to);

    public List<Transaction> findByTransactionType(String transactionType);

    @Query(value = "from Transaction t INNER JOIN t.wallet w where w.walletId=?1")
    public List<Transaction> findByWallet(Integer walletId);

}
