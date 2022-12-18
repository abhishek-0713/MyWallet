package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Beneficiary;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;
import com.mywallet.repository.BankAccountRepo;
import com.mywallet.repository.BeneficiaryRepo;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private BankAccountRepo bankAccountRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	public CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	public CurrentSessionRepo user;
	
	@Autowired
	public TransactionService transactionService;
	
	
	
	
	
	/*---------------------------------   Create Wallet Account  -------------------------------------*/
	@Override
	public Customer createAccount(Customer customer) throws CustomerException {


		Optional<Customer> customers = customerRepo.findByMobileNumber(customer.getMobileNumber());
		
		if(customers.isEmpty()) {
			
			Wallet wallet = new Wallet();
			wallet.setBalance(Double.valueOf(0));
		
			wallet.setCustomer(customer);
			walletRepo.save(wallet);
			
			return customerRepo.save(customer);
		}		
		throw new CustomerException("This mobile number is already registered with EZWallet");
	

	
		
	}

	
	/*---------------------------------   Show Wallet Balance  -------------------------------------*/
	@Override
	public Double showBalance(String key) throws CustomerException {
		
		// TODO Auto-generated method stub
		
		CurrentUserSession validcustomer=currentSessionRepo.findByUuid(key);
		
		if(validcustomer==null) {
			throw new CustomerException("Please login first...");
		}else {
			Optional<Customer> c=customerRepo.findById(validcustomer.getUserId());
			
			Wallet wallet=c.get().getWallet();
			
			Double b=wallet.getBalance();
			return b;
			
		}
		
	}

	/*---------------------------------   Fund Transfer  -------------------------------------*/
	@Override
	public Transaction fundTransfer(String srcMobileNumber, String targetMobileNumber, Double amount, String key)
			throws WalletException, TransactionException {
		// TODO Auto-generated method stub
		
		CurrentUserSession validCustomer=user.findByUuid(key);
		
		if(validCustomer==null) {
			throw new TransactionException("please provide a valid key");
		}
		
		Optional<Customer> c=customerRepo.findByMobileNumber(srcMobileNumber);
		
		Customer customer=c.get();
		Wallet wallet=customer.getWallet();
		
//		List<Beneficiary> beneficiary=wallet
		
		
		
		return null;
	}

	
	/*---------------------------------   Deposit Amount  -------------------------------------*/
	@Override
	public BankAccount depositAmount(Double amount, Integer accountNo, String key) throws BankAccountException, WalletException {
		// TODO Auto-generated method stub
		CurrentUserSession validCustomer=user.findByUuid(key);
		
		BankAccount c=new BankAccount();
		
		if(validCustomer==null) {
			throw new BankAccountException("please provide a valid key to deposit the amount");
		}
		
		if(c.getAccountNumber()==validCustomer.getUserId()) {
			BankAccount ba=bankAccountRepo.findById(accountNo).orElseThrow(()->new WalletException("Bank Account does not exist to deposit the amount"));
			
			ba.setBalance(ba.getBalance()+amount);
			
			return bankAccountRepo.save(ba);
			
		}else {
			 throw new BankAccountException("not enough money to transfer");
		}
	}

	
	/*---------------------------------   View Customers List   -------------------------------------*/
	@Override
	public List<Beneficiary> getList(String key) throws BeneficiaryException,LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession validUser=currentSessionRepo.findByUuid(key);
		
		if(validUser==null) {
			throw new LoginException("please provide a valid key");
		}else {
			
			Optional<Customer> c=customerRepo.findById(validUser.getUserId());
			
			Customer customer=c.get();
			Wallet wallet=customer.getWallet();
			
			List<Beneficiary> beneficiary=wallet.getBeneficiary();
			
			if(beneficiary==null) {
				throw new BeneficiaryException("beneficiary is not added in your wallet..");
			}
			
			return wallet.getBeneficiary();
			
		}
		
	}

	
	/*---------------------------------   Update Account  -------------------------------------*/
	@Override
	public Customer updateAccount(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		CurrentUserSession validUser=currentSessionRepo.findByUuid(key);
		
		if(validUser==null) {
			throw new CustomerException("Please provide a valid key to update customer account");
		}
		
		if(customer.getCustomerId()==validUser.getUserId()) {
			return customerRepo.save(customer);
		}else {
			throw new CustomerException("Invalid customer details, Please login first");
		}
		
	}

	
	/*---------------------------------   Add Money To Wallet  -------------------------------------*/
	@Override
	public Customer addMoney(Double amount, String key) throws BankAccountException, LoginException{
		// TODO Auto-generated method stub
		
		CurrentUserSession validUser=currentSessionRepo.findByUuid(key);
		
		if(validUser==null) {
			throw new LoginException("please provide a valid key to addmoney..");
		}
		
		Optional<Customer> c=customerRepo.findById(validUser.getUserId());
		
		Customer customer=c.get();
		Wallet wallet=customer.getWallet();
		
		BankAccount ba=bankAccountRepo.findByWalletId(wallet.getWalletId());
		
		if(ba==null) {
			throw new BankAccountException("Bank Account is not exist..");
		}
		
		ba.setBalance(ba.getBalance()+amount);
		
		wallet.setBalance(wallet.getBalance()+amount);
		
		bankAccountRepo.save(ba);
		walletRepo.save(wallet);
		customerRepo.save(customer);
		
		
		return customer;
	}

}
