package com.mywallet.service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;
import com.mywallet.model.dto.BankAccountDTO;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
	
	public Wallet addBankAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException,CustomerException;
	
	public Wallet removeBankAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException;
	
	public Optional<BankAccount> viewBankAccount(String key, Integer accountNo) throws BankAccountException, CustomerException;
	
	public List<BankAccount> viewAllBankAccounts(String key) throws BankAccountException, CustomerException;

}
