package com.mywallet.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;
	
	/*---------------------------------   Add Transaction  -------------------------------------*/
	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionException, WalletException {
		
		Optional<Wallet> optional =	walletRepo.findById(transaction.getWallet().getWalletId());
		
		if(optional.isPresent()) {
			
			if(transactionRepo.save(transaction) != null) {
				return transaction;
			}
	     	throw new TransactionException("No Transaction data Found");
		}
		throw new WalletException("Invlid WalletId");
		
	}

	
	/*---------------------------------   View All Transaction  -------------------------------------*/
	@Override
	public List<Transaction> viewAllTransaction() throws TransactionException {
		
		List<Transaction> transactions = transactionRepo.findAll();
		
		if(transactions.isEmpty()) {
			throw new TransactionException("No Transaction Yet To Show");
		}
		return transactions;
	}

	
	/*---------------------------------   View Transaction By Date  -------------------------------------*/
	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate fromDate, LocalDate toDate, String key) throws TransactionException, CustomerException {
		
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");
		}
		
		LocalDate currentDate = LocalDate.now();
		
		if(fromDate.isAfter(currentDate)) {
			throw new TransactionException("Starting Date is Future [ select present/past ] ");
		}
		if(toDate.isAfter(currentDate)) {
			throw new TransactionException("Ending Date is Future [ select present/past ]");
		}
		if(fromDate.isAfter(toDate)) {
			throw new TransactionException("Invalid Date Format");
		}
		
		
		List<Transaction> listOfTransactions= transactionRepo.findByTransactionDateBetween(fromDate, toDate);
		
		return listOfTransactions;
	}

	
	/*---------------------------------   View All Transaction By Date  -------------------------------------*/
	@Override
	public List<Transaction> viewAllTransactionByType(String transactionType, String key) throws TransactionException, CustomerException {
		
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");
		}
		
		List<Transaction> transactions = transactionRepo.findByTransactionType(transactionType);
		
		if(transactions.isEmpty()) {
			throw new TransactionException("No Transaction Yet To Show");
		}
		return transactions;
	}




}
