package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;


public interface WalletService {

	public Customer createAccount(Customer customer) throws CustomerException;
	
	public Integer showBalance(Customer customer, String key) throws CustomerException;
	
	public String fundTransfer(String srcMobileNumber,String targetMobileNumber, BigDecimal amount, String key) throws WalletException,TransactionException;
	
	public BankAccount depositAmount(Double amount,Integer accountNo, String key) throws BankAccountException,WalletException;
	
    public List<Customer> getList(Customer customer, String key) throws CustomerException;
   
    public Customer updateAccount(Customer customer, String key) throws CustomerException;
    
    public Customer addMoney(Wallet wallet, Double amount, String key) throws WalletException,BankAccountException;
    	
}