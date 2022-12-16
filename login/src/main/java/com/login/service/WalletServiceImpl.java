package com.login.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.exception.CustomerException;
import com.login.model.Customer;
import com.login.model.Wallet;
import com.login.repo.CurrentSessionDao;
import com.login.repo.CustomerRepository;
import com.login.repo.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	public CustomerRepository customerRepo; 
	
	@Autowired
	public WalletRepository walletRepo;
	
	@Autowired
	public CurrentSessionDao user;
	
//	@Autowired
//	public BankAccountDao bankRepo;
//	
//	@Autowired
//	public TransactionService transactionServe;
//	
//	@Autowired
//	public BeneficiaryDao beneficiaryRepo;	
	
	@Autowired
	public CurrentSessionDao currentSessionRepo;
	
	@Override
	public Customer createCustomerAccount(Customer customer) throws CustomerException {
		
		List<Customer> cust = customerRepo.findCustomerByMobile(customer.getMobileNumber());
		
		if(!cust.isEmpty()) throw new CustomerException("This mobile number is already registered with EZWallet");
		
		else  {		
			Wallet wallet = new Wallet();
			wallet.setBalance(BigDecimal.valueOf(0));
		
			wallet.setCustomer(customer);
			 walletRepo.save(wallet);
			return customerRepo.save(customer);
			
		}	
	}

//	@Override
//	public BigDecimal showWalletBalance(String key) throws CustomerException {
//		
//		if(key==null) throw new CustomerException("Please log in to continue");
//		
//		CurrentUserSession user = currentSessionRepo.findByUuid(key);
//		
//		if(user==null) throw new CustomerException("Please log in to continue");		
//		
//		else {
//			
//			Integer id = user.getUserId();
//			Wallet wl = walletRepo.showWalletDetails(id);
//			
//			return wl.getBalance();
//		}
//		
//		
//	}

//	@Override
//	public String addMoneyFromBankToWallet(Integer accountNo, Double amount, String key) throws BankAccountException, CustomerException, TransactionException, WalletException {
//		
//		if(key==null) throw new CustomerException("Please log in to continue");
//		
//		CurrentUserSession user = currentSessionRepo.findByUuid(key);
//		
//		if(user==null) throw new CustomerException("Please log in to continue");
//		
//		
////		Checking bank Accounts
//		Integer id = user.getUserId();
//		Wallet wallet = walletRepo.showWalletDetails(id);
//		
//		List<BankAccount> accounts = bankRepo.findAllByWallet(wallet.getWalletId());
//		System.out.println(accounts);
//		System.out.println(accountNo);
//		if(accounts.size()==0) throw new BankAccountException("Add bank account for transaction");
//		
//		BankAccount acct=null;
////		boolean flag=false;
//		
//		for(BankAccount b : accounts) {
//			if((b.getAccountNo().toString()).equals(accountNo.toString())) {
//				acct=b;
//				break;
//			}
//			
//		}
//		
//		if(acct==null) throw new BankAccountException("Bank account number does not match the data of saved accounts");
//				
//		if(acct.getBalance() < amount) throw new BankAccountException("Insufficient balance in account");
//		
//		acct.setBalance(acct.getBalance()-amount);
//		wallet.setBalance(wallet.getBalance().add(BigDecimal.valueOf(amount)));
//		
//		bankRepo.save(acct);
//		
//		Transaction trans = new Transaction();
//		trans.setTransactionType("Bank transfer");
//		trans.setTransactionDate(LocalDate.now());
//		trans.setAmount(amount);
//		trans.setWallet(wallet);
//		trans.setDescription("transferred from bank "+acct.getBankName()+" to wallet");
//		
//		transactionServe.addTransaction(trans);	
//		
//		
//		return "Your bank account no "+ accountNo +" debited for "+ amount +" Rs" ;
//	}
//
//	@Override
//	public String fundTransferToAnotherMobileNumber(String targetMobile, String Name, BigDecimal amount, String key)
//			throws WalletException, CustomerException, TransactionException {
//
//		if(key==null) throw new CustomerException("Please log in to continue");
//		
//		CurrentUserSession user = currentSessionRepo.findByUuid(key);
//		
//		if(user==null) throw new CustomerException("Please log in to continue");
//		
//		
////		Checking beneficiary
//		Integer id = user.getUserId();
//		Wallet wallet = walletRepo.showWalletDetails(id);
//		
//		Beneficiary beneficiary = new Beneficiary(targetMobile, Name, wallet);
//		
//		List<Beneficiary> beneficiaries = beneficiaryRepo.findByWallet(wallet.getWalletId());
//		
//		if(!beneficiaries.contains(beneficiary)) beneficiaryRepo.save(beneficiary);
//		
//				
//		List<Customer> customers =  customerRepo.findCustomerByMobile(targetMobile);
//		
//		if(customers.isEmpty()) throw new CustomerException("Customer with mobile number "+ targetMobile+" does not exist on EZWallet");
//		
//		Wallet targetWallet = walletRepo.showWalletDetails(customers.get(0).getCustomerId());
//		
//		if(wallet.getBalance().compareTo(amount)<0) throw new WalletException("Add more amount in wallet for transaction");
//		
//		targetWallet.setBalance(targetWallet.getBalance().add(amount));
//		walletRepo.save(targetWallet);
//		
//		wallet.setBalance(wallet.getBalance().subtract(amount));
//		walletRepo.save(wallet);
//		
//		
//		Transaction trans = new Transaction();
//		trans.setTransactionType("Bank transfer");
//		trans.setTransactionDate(LocalDate.now());
//		trans.setAmount(amount.doubleValue());
//		trans.setWallet(wallet);
//		trans.setDescription(amount +" transfered to "+ targetMobile);
//		
//		transactionServe.addTransaction(trans);	
//		
//		
//		
//		return "Fund Transfered successfully...";
//	}
//
//	@Override
//	@Transactional
//	public Customer updateCustomerDetails(Customer customer, String key) throws CustomerException {
//		
//		if(key==null) throw new CustomerException("Please log in to continue");
//		
//		CurrentUserSession user = currentSessionRepo.findByUuid(key);
//		
//		if(user==null) throw new CustomerException("Please log in to continue");
//		
//		
//		Optional<Customer> cust = customerRepo.findById(user.getUserId());
//		
//		
//		if(!cust.isPresent()) throw new CustomerException("Customer does not exist");
//		
//		customer.setCustomerId(user.getUserId());
//		
//		return customerRepo.save(customer);		
//		
//		
//	}

}
