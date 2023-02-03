package com.mywallet.service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;

import java.math.BigDecimal;

public interface WalletService {

	public Customer createCustomerAccount(Customer customer) throws CustomerException;

	public BigDecimal showBalance(String mobile, String key) throws CustomerException;

	public String fundTransfer(String name, String targetMobileNumber, BigDecimal amount, String key) throws WalletException, TransactionException, CustomerException;

	public String depositAmount(BigDecimal amount, Integer accountNo, String key) throws BankAccountException, WalletException, CustomerException, TransactionException;

//	public List<Customer> getList(Customer customer, String key) throws CustomerException;

	public Customer updateAccount(Customer customer, String key) throws CustomerException;

	public String addMoney(Wallet wallet, Integer accountNo, BigDecimal amount, String key) throws WalletException, BankAccountException, CustomerException, TransactionException;

}