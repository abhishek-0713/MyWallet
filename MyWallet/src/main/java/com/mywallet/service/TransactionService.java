package com.mywallet.service;

import java.time.LocalDate;
import java.util.List;

import com.mywallet.exceptions.TransactionException;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction) throws TransactionException;
	
	public Transaction viewAllTransaction(Wallet wallet) throws TransactionException;
	
	public List<Transaction> viewTransactionsByDate(LocalDate localDate)throws TransactionException;
	
	public List<Transaction> viewAllTransactionByType(String transactionType) throws TransactionException;
	
}
