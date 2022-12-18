package com.mywallet.service;


import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;
import com.mywallet.model.dto.BankAccountDTO;

public interface AccountService {
	
	public Wallet addAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException,CustomerException;
	
	public Wallet removeAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException;
	
	public BankAccount viewAccount(String key) throws BankAccountException, CustomerException;
	
	public List<BankAccount> viewAllAccount(String key) throws BankAccountException, CustomerException;


}
