package com.mywallet.service;

import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;


public interface AccountService {

	public Wallet addAccount(BankAccount ba) throws WalletException;
	
	public Wallet removeAccount(Integer accno) throws BankAccountException;
	
	public BankAccount viewAccount(Wallet wallet) throws BankAccountException;
	
	public List<BankAccount> viewAllAccount(Wallet wallet) throws BankAccountException;
	
}
