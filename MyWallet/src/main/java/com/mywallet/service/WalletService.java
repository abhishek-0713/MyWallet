package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Beneficiary;
import com.mywallet.model.Customer;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;


public interface WalletService {

	public Customer createAccount(Customer customer) throws CustomerException;
	
	public Double showBalance(String key) throws CustomerException;
	
	public Transaction fundTransfer(String srcMobileNumber,String targetMobileNumber, Double amount, String key) throws WalletException,TransactionException;
	
	public BankAccount depositAmount(Double amount,Integer accountNo, String key) throws BankAccountException,WalletException;
	
    public List<Beneficiary> getList(String key) throws BeneficiaryException,LoginException;
   
    public Customer updateAccount(Customer customer, String key) throws CustomerException;
    
    public Customer addMoney(Double amount, String key) throws BankAccountException,LoginException;
    	
}