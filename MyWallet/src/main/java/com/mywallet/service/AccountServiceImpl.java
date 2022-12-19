package com.mywallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Wallet;
import com.mywallet.model.dto.BankAccountDTO;
import com.mywallet.repository.BankAccountRepo;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	 private CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	private BankAccountRepo bankAccountRepo;
	
	@Autowired
	private WalletRepo walletRepo;
	
//	@Autowired
//	private CustomerRepo customerRepo;

	
	
	/*--------------------------------------------     Add Bank Account    -----------------------------------------------*/
	
	@Override
	public Wallet addAccount(String key,BankAccountDTO bankAccount)  throws BankAccountException,CustomerException{
		return null;	
        
	
	}
	
	
	/*--------------------------------------------     Remove Bank Account    -----------------------------------------------*/
	
	@Override
	public Wallet removeAccount(String key, BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException{
		return null;
		
	}

	
	/*--------------------------------------------     View Bank Account    -----------------------------------------------*/

	@Override
	public BankAccount viewAccount(String key) throws BankAccountException,CustomerException{
		return null;
		
 	}

	
	/*--------------------------------------------     View Wallet All Bank Account    -----------------------------------------------*/

	@Override
	public List<BankAccount> viewAllAccount(String key) throws BankAccountException,CustomerException{
		return null;
		
		
	}

}
