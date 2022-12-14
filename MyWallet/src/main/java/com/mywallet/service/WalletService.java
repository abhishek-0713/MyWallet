package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;


public interface WalletService {

	public Customer createAccount(Customer customer) throws CustomerException;
	
	public Customer showBalance(String mobile) throws CustomerException;
	
	public String fundTransfer(String srcMobileNumber,String targetMobileNumber, BigDecimal amount) throws WalletException,TransactionException;
	
	public Customer depositAmount(BigDecimal amount,Integer accno) throws BankAccountException,WalletException;
	
    public List<Customer> getList(Customer customer) throws CustomerException;
   
    public Customer updateAccount(Integer accno,Customer customer) throws CustomerException;
    
    public Customer addMoney(Wallet wallet, BigDecimal amount) throws WalletException,BankAccountException;
    
	
}