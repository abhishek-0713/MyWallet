package com.mywallet.service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Wallet;
import com.mywallet.model.dto.BankAccountDTO;
import com.mywallet.repository.BankAccountRepo;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	private BankAccountRepo bankAccountRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	private WalletRepo walletRepo;



	/*---------------------------------------   Add Customer Bank Account  -------------------------------------------*/
	@Override
	public Wallet addBankAccount(String key,BankAccountDTO bankAccountDTO)  throws BankAccountException,CustomerException{
        
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
        if(currUserSession==null) {
    		throw new CustomerException("No Customer LoggedIn");
		}
		
		Optional<BankAccount> optional = bankAccountRepo.findById(bankAccountDTO.getAccountNo());
		if(optional.isEmpty()){	
			  
			Wallet wallet =  walletRepo.showCustomerWalletDetails(currUserSession.getUserId());
			  
			BankAccount createBankAccount = new BankAccount(bankAccountDTO.getAccountNo(), bankAccountDTO.getIFSCCode(), bankAccountDTO.getBankName(), bankAccountDTO.getBalance());
			createBankAccount.setWallet(wallet);
			   
			bankAccountRepo.save(createBankAccount);

			return wallet;
		  }
		  throw new BankAccountException("Bank Account already exist With Given AccountNumber... Try Different");
	
 
	}


	/*---------------------------------------   Remove Customer Bank Account  ----------------------------------------*/
	@Override
	public Wallet removeBankAccount(String key, BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException{

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


	/*---------------------------------------   View Customer Bank Account  ------------------------------------------*/
	@Override
	public Optional<BankAccount> viewBankAccount(String key, Integer accountNo) throws BankAccountException,CustomerException{
 
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
        if(currUserSession == null) {
    		throw new CustomerException("No Customer LoggedIn");
		}
		
		
		Optional<BankAccount> bankAccount = bankAccountRepo.findById(accountNo);
		if(bankAccount == null) {
			throw new BankAccountException("No Bank Account exist");
		}
		return bankAccount;
	}


	/*-------------------------------------   View Customers All Bank Account  ---------------------------------------*/
	@Override
	public List<BankAccount> viewAllBankAccounts(String key) throws BankAccountException,CustomerException{
		
		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
        if(currUserSession == null) {
    		throw new CustomerException("No Customer LoggedIn");
		}

		List<BankAccount> bankAccounts = bankAccountRepo.findAllByWallet(walletRepo.showCustomerWalletDetails(currUserSession.getUserId()).getWalletId());
		if(bankAccounts == null) {
			throw new BankAccountException("No Bank Account exist");
		}
		return bankAccounts;
	}

}
