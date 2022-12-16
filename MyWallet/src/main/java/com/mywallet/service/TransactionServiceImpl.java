package com.mywallet.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.TransactionException;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private WalletRepo walletRepo;
	
	/*---------------------------------   Add Transaction  -------------------------------------*/
	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View All Transaction  -------------------------------------*/
	@Override
	public Transaction viewAllTransaction(Wallet wallet, String key) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View Transaction By Date  -------------------------------------*/
	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate localDate, String key) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View All Transaction By Date  -------------------------------------*/
	@Override
	public List<Transaction> viewAllTransactionByType(String transactionType, String key) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

}
