package com.mywallet.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Beneficiary;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;
import com.mywallet.repository.BeneficiaryRepo;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo walletRepo;
	
//	@Autowired
//	private BankAccountRepo bankAccountRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
//	@Autowired
//	private TransactionRepo transactionRepo;
	
	@Autowired
	public CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	public CurrentSessionRepo customer;
	
	@Autowired
	public TransactionService transactionService;
	
	
	
	
	
	/*---------------------------------   Create Wallet Account  -------------------------------------*/
	@Override
	public Customer createAccount(Customer customer) throws CustomerException {


		List<Customer> customers = customerRepo.findCustomerByMobile(customer.getMobileNumber());
		
		if(customers.isEmpty()) {
			
			Wallet wallet = new Wallet();
			wallet.setBalance(BigDecimal.valueOf(0));
		
			wallet.setCustomer(customer);
			walletRepo.save(wallet);
			
			return customerRepo.save(customer);
		}		
		throw new CustomerException("Mobile Number Already Linked To Another Account");
	
	}
	
	
	/*---------------------------------   Update Account  -------------------------------------*/
	@Override
	public Customer updateAccount(Customer customer, String key) throws CustomerException {		

		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");		
		}
		
		Optional<Customer> optional = customerRepo.findById(currentUserSession.getUserId());
		
		if(optional.isPresent()) {
			
			customer.setCustomerId(currentUserSession.getUserId());
			
			return customerRepo.save(customer);		
		}
		throw new CustomerException("No Customer Exist");
		
	}

	
	/*---------------------------------   Show Wallet Balance  -------------------------------------*/
	@Override
	public BigDecimal showBalance(String mobile, String key) throws CustomerException {
		
		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");		
		}

		Integer userId = currentUserSession.getUserId();
		
		Wallet wallet = walletRepo.customerWalletDetailsByCId(userId);
			
		return wallet.getBalance();
		
	}

	/*---------------------------------   Fund Transfer  -------------------------------------*/
	@Override
	public String fundTransfer(String name, String targetMobileNumber, BigDecimal amount, String key) throws WalletException, TransactionException, CustomerException {
		
		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");		
		}
		

		
		
		Integer userId = currentUserSession.getUserId();
		Wallet wallet = walletRepo.customerWalletDetailsByCId(userId);
		
		Beneficiary beneficiary = new Beneficiary(targetMobileNumber, name, wallet);
		
		List<Beneficiary> beneficiaries = beneficiaryRepo.findByWallet(wallet.getWalletId());
		
		if(!beneficiaries.contains(beneficiary)) {
			beneficiaryRepo.save(beneficiary);
		}
		
		
		
				
		List<Customer> customers =  customerRepo.findCustomerByMobile(targetMobileNumber);
		
		if(customers.isEmpty()) {
			throw new CustomerException("Customer mobile number "+ targetMobileNumber + " not linked to any Account" );
		}
		
		Wallet targetWallet = walletRepo.customerWalletDetailsByCId(customers.get(0).getCustomerId());
		
		if(wallet.getBalance().compareTo(amount) < 0) {
			throw new WalletException("Insufficient Balance for Transaction");
		}
		
		targetWallet.setBalance(targetWallet.getBalance().add(amount));
		walletRepo.save(targetWallet);
		
		wallet.setBalance(wallet.getBalance().subtract(amount));
		walletRepo.save(wallet);
		
		
		Transaction transaction = new Transaction(LocalDate.now(), "Bank transfer", amount.doubleValue(), " Fund Transfered to mobileNumber "+ targetMobileNumber );
		transaction.setWallet(wallet);
		
		transactionService.addTransaction(transaction);	
		
		return "Fund Transfered successfully!!!!";
	}

	
	/*---------------------------------   Deposit Amount  -------------------------------------*/
	@Override
	public Customer depositAmount(BigDecimal amount, Integer accountNo, String key) throws BankAccountException, WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View Customers List   -------------------------------------*/
	@Override
	public List<Customer> getList(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Add Money To Wallet  -------------------------------------*/
	@Override
	public Customer addMoney(BigDecimal amount, Integer accountNumber, String key) throws WalletException, BankAccountException {
		return null;

//		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
//		
//		if(currentUserSession == null) {
//			throw new CustomerException("No Customer LoggedIn");		
//		}
//		
//		
//		
//		Integer userId = currentUserSession.getUserId();
//		Wallet wallet = walletRepo.customerWalletDetailsByCId(userId);
//		
//		List<BankAccount> bankAccounts = bankAccountRepo.findAllByWalletId(wallet.getWalletId());
//	
//		if(bankAccounts.isEmpty()) {
//			throw new BankAccountException("No Bank Account Linked To Wallet Yet");
//		}
//		
//		
//		
//		
//		BankAccount bankAccount = null;
//		
//		for(BankAccount b : bankAccounts) {
//			
//			if((b.getAccountNumber().toString()).equals(accountNumber.toString())) {
//				bankAccount = b;
//				break;
//			}
//			
//		}
//		
//		if(bankAccount == null) {
//			throw new BankAccountException("Invalid Bank Account Number");
//		}
//				
//		if(bankAccount.getBalance() < amount.compareTo(amount)) {
//			throw new BankAccountException("Insufficient balance For Transaction");
//		}
//		
//		bankAccount.setBalance(bankAccount.getBalance() - amount.compareTo(amount));
//		wallet.setBalance(wallet.getBalance().add(Bi.valueOf(amount)));
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
//		return  accountNumber + " ";
	
	}
	

}
