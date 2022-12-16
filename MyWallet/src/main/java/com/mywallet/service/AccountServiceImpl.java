package com.mywallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;
import com.mywallet.repository.BankAccountRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private BankAccountRepo bankAccountRepo;
	
	/*---------------------------------   Add Customer Bank Account  -------------------------------------*/
	@Override
	public Wallet addAccount(BankAccount bankAccount, String key) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Remove Customer Bank Account  -------------------------------------*/
	@Override
	public Wallet removeAccount(Integer accountNo, String key) throws BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View Customer Bank Account  -------------------------------------*/
	@Override
	public BankAccount viewAccount(Wallet wallet, String key) throws BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View All Customers Account  -------------------------------------*/
	@Override
	public List<BankAccount> viewAllAccount(Wallet wallet, String key) throws BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
