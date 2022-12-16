package com.mywallet.service;

import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;


public interface AccountService {

	public Wallet addAccount(BankAccount bankAccount, String key) throws WalletException;
	
	public Wallet removeAccount(Integer accountNo, String key) throws BankAccountException;
	
	public BankAccount viewAccount(Wallet wallet, String key) throws BankAccountException;
	
	public List<BankAccount> viewAllAccount(Wallet wallet, String key) throws BankAccountException;
	
}
