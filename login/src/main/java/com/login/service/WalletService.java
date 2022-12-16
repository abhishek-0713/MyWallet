package com.login.service;

import com.login.exception.CustomerException;
import com.login.model.Customer;



public interface WalletService {

	public Customer createCustomerAccount(Customer customer) throws CustomerException;
	
//	public Customer updateCustomerDetails(Customer customer, String key) throws CustomerException;
//	
//	public BigDecimal showWalletBalance(String key) throws CustomerException;
//	
//	public String addMoneyFromBankToWallet(Integer accountNo, Double amount, String key) throws BankAccountException, CustomerException, TransactionException, WalletException;
//	
//	public String fundTransferToAnotherMobileNumber(String targetMobile, String name, BigDecimal amount, String key) throws WalletException, CustomerException, TransactionException;


}
