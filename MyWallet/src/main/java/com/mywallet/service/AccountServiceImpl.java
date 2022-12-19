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
        
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		
        if(currUserSession==null) {
    		throw new CustomerException("No Customer LoggedIn");
		}
		
		Optional<BankAccount> optional = bankAccountRepo.findById(bankAccount.getAccountNo());
	
		
		if(optional.isEmpty()){	
			  
			   Wallet wallet =  walletRepo.customerWalletDetailsByCId(currUserSession.getUserId());
			  
			  BankAccount createBankAccount = new BankAccount(bankAccount.getAccountNo(), bankAccount.getIFSCCode(), bankAccount.getBankName(), bankAccount.getBalance());
			  createBankAccount.setWallet(wallet); 
			   
			  bankAccountRepo.save(createBankAccount);

			  return wallet;
		  }
		 
		throw new BankAccountException("Bank Account already exist With Given AccountNumber... Try Different");
	
	}
	
	
	/*--------------------------------------------     Remove Bank Account    -----------------------------------------------*/
	
	@Override
	public Wallet removeAccount(String key, BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException{

		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		
        if(currUserSession==null) {
    		throw new CustomerException("No Customer LoggedIn");
		}
		
		Optional<BankAccount> optional = bankAccountRepo.findById(bankAccountDTO.getAccountNo());
		
		if(optional.isPresent()) {
			
			bankAccountRepo.delete(optional.get());
			
			Wallet wallet = optional.get().getWallet();
			
			return wallet;

		} 

		throw new BankAccountException("No Bank Account exist");
		
	}

	
	/*--------------------------------------------     View Bank Account    -----------------------------------------------*/

	@Override
	public BankAccount viewAccount(String key) throws BankAccountException,CustomerException{
		
 
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		
        if(currUserSession == null) {
    		throw new CustomerException("No Customer LoggedIn");
		}
		
		
		BankAccount bankAccount= bankAccountRepo.findByWalletId(walletRepo.customerWalletDetailsByCId(currUserSession.getUserId()).getWalletId()).get(0);
		
		if(bankAccount == null) {
			
			throw new BankAccountException("No Bank Account exist");
		}
		
		return bankAccount;
	}

	
	/*--------------------------------------------     View Wallet All Bank Account    -----------------------------------------------*/

	@Override
	public List<BankAccount> viewAllAccount(String key) throws BankAccountException,CustomerException{
		
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		
        if(currUserSession == null) {
    		throw new CustomerException("No Customer LoggedIn");
		}
		
		
		List<BankAccount> bankAccounts = bankAccountRepo.findAllByWalletId(walletRepo.customerWalletDetailsByCId(currUserSession.getUserId()).getWalletId());
		
		if(bankAccounts == null) {
			
			throw new BankAccountException("No Bank Account exist");
		}
		
		return bankAccounts;
	}

}
