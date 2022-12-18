package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;


public interface WalletService {

	public Customer createAccount(Customer customer) throws CustomerException;
	
    public Customer updateAccount(Customer customer, String key) throws CustomerException;

	public BigDecimal showBalance(String mobile, String key) throws CustomerException;
	
	public String fundTransfer(String name, String targetMobileNumber, BigDecimal amount, String key) throws WalletException,TransactionException, CustomerException;
	
	public Customer depositAmount(BigDecimal amount,Integer accountNo, String key) throws BankAccountException,WalletException;
	
    public List<Customer> getList(Customer customer, String key) throws CustomerException;
       
    public Customer addMoney(BigDecimal amount, Integer accountNumber, String key) throws WalletException,BankAccountException;
    	
}