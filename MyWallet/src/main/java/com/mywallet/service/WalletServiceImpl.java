package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
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


		List<Customer> customers = customerRepo.findCustomerByMobile(customer.getMobileNumber());
		
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
	public Integer showBalance(Customer customer, String key) throws CustomerException {
		
		// TODO Auto-generated method stub
		
		CurrentUserSession validCustomer=user.findByUuid(key);
		
		if(validCustomer==null) {
			throw new CustomerException("please provide a valid key to show your Account balanace");
			
		}
		
		if(customer.getCustomerId()==validCustomer.getUserId()) {
			Customer c=new Customer();
			
		}
		return null;
	}

	/*---------------------------------   Fund Transfer  -------------------------------------*/
	@Override
	public String fundTransfer(String srcMobileNumber, String targetMobileNumber, BigDecimal amount, String key)
			throws WalletException, TransactionException {
		// TODO Auto-generated method stub
		
		CurrentUserSession validCustomer=user.findByUuid(key);
		
		if(validCustomer==null) {
			throw new TransactionException("please provide a valid key");
		}
		
		
		
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
	public List<Customer> getList(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
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
	public Customer addMoney(Wallet wallet, Double amount, String key) throws WalletException, BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
