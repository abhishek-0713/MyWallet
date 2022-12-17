package com.mywallet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;
	
	/*---------------------------------   Add Transaction  -------------------------------------*/
	@Override
	public Transaction addTransaction(Transaction transaction){
		
		return transactionRepo.save(transaction);
	}

	
	/*---------------------------------   View All Transaction  -------------------------------------*/
	@Override
	public List<Transaction> viewAllTransaction(String key) throws TransactionException, WalletException {
		CurrentUserSession cur = currentSessionRepo.findByUuid(key);
		
		if(cur==null) throw new TransactionException("Invalid Session Key");
		
		Optional<Customer> customer = customerRepo.findById(cur.getUserId());
		
		Optional<Wallet> wallet = walletRepo.findById(customer.get().getWallet().getWalletId());
		
		if(!wallet.isPresent()) throw new WalletException("Invalid Wallet Details");	
		
		return wallet.get().getTransactions();
	}

	
	/*---------------------------------   View Transaction By Date  -------------------------------------*/
	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate localDate, String key) throws TransactionException, WalletException {
        CurrentUserSession cur = currentSessionRepo.findByUuid(key);
		
		if(cur==null) throw new TransactionException("Invalid Session Key");
		
		Optional<Customer> customer = customerRepo.findById(cur.getUserId());
		
		Optional<Wallet> wallet = walletRepo.findById(customer.get().getWallet().getWalletId());
		
		if(!wallet.isPresent()) throw new WalletException("Invalid Wallet Details");
		
		List<Transaction> filter=new ArrayList<>();
		
		for(Transaction t:wallet.get().getTransactions()) {
			if(t.getTransactionDate().equals(localDate)) {
				filter.add(t);
			}
		}
		if(filter.size()==0) throw new TransactionException("Transaction Not exist with this date");
		
		return filter;
	}

	
	/*---------------------------------   View All Transaction By Date  -------------------------------------*/
	@Override
	public List<Transaction> viewAllTransactionByType(String transactionType, String key) throws TransactionException, WalletException {
		    CurrentUserSession cur = currentSessionRepo.findByUuid(key);
			
			if(cur==null) throw new TransactionException("Invalid Session Key");
			
			Optional<Customer> customer = customerRepo.findById(cur.getUserId());
			
			Optional<Wallet> wallet = walletRepo.findById(customer.get().getWallet().getWalletId());
			
			if(!wallet.isPresent()) throw new WalletException("Invalid Wallet Details");
			
			List<Transaction> filter=new ArrayList<>();
			
			for(Transaction t:wallet.get().getTransactions()) {
				if(t.getTransactionType().equals(transactionType)) {
					filter.add(t);
				}
			}
			if(filter.size()==0) throw new TransactionException("Transaction Not exist with this date");
			
			return filter;
	}

}
