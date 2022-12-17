package com.mywallet.service;

import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;


public interface AccountService {

	public Wallet addAccount(BankAccount bankAccount, String key) throws WalletException, BankAccountException, CustomerException;
	
	public Wallet removeAccount(BankAccount bankAccount, String key) throws BankAccountException;
	
	public BankAccount viewAccount(String key) throws BankAccountException, CustomerException;
	
	public List<BankAccount> viewAllAccount(String key) throws BankAccountException, CustomerException;

	
}
