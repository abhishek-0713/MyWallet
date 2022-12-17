package com.mywallet.service;

import java.time.LocalDate;
import java.util.List;

import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction) throws TransactionException;
	
	public List<Transaction> viewAllTransaction(String key) throws TransactionException,WalletException;
	
	public List<Transaction> viewTransactionsByDate(LocalDate localDate, String key)throws TransactionException,WalletException;
	
	public List<Transaction> viewAllTransactionByType(String transactionType, String key) throws TransactionException,WalletException;
	
}
