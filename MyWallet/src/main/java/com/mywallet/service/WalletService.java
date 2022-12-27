package com.mywallet.service;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.Customer;


public interface WalletService {

	public Customer createCustomerAccount(Customer customer) throws CustomerException;
	
}