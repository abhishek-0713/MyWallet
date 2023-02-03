package com.mywallet.service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.*;
import com.mywallet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo walletRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	@Autowired
	private BeneficiaryRepo beneficiaryRepo;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private BankAccountRepo  bankAccountRepo;

	/*-----------------------------------------   Create Wallet Account  ---------------------------------------------*/
	@Override
	public Customer createCustomerAccount(Customer customer) throws CustomerException {

		List<Customer> customers = customerRepo.findCustomerByMobile(customer.getMobileNumber());

		if(customers.isEmpty()) {

			Wallet wallet = new Wallet();
			wallet.setBalance(BigDecimal.valueOf(0));

			wallet.setCustomer(customer);
			walletRepo.save(wallet);

			return customerRepo.save(customer);
		}
		throw new CustomerException("Duplicate Mobile Number [ Already Registered with different customer ] ");

	}


	/*------------------------------------------   Show Wallet Balance  ----------------------------------------------*/
	@Override
	public BigDecimal showBalance(String mobile, String key) throws CustomerException {

		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession==null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Integer userId = currUserSession.getUserId();
		Wallet wallet = walletRepo.showCustomerWalletDetails(userId);

		return wallet.getBalance();

	}


	/*---------------------------------------------   Fund Transfer  -------------------------------------------------*/
	@Override
	public String fundTransfer( String name, String targetMobileNumber, BigDecimal amount, String key) throws WalletException, CustomerException, TransactionException {

		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession==null) {
			throw new CustomerException("No Customer LoggedIn");
		}


		Integer userId = currUserSession.getUserId();
		Wallet wallet = walletRepo.showCustomerWalletDetails(userId);

		Beneficiary beneficiary = new Beneficiary(targetMobileNumber, name);

		List<Beneficiary> beneficiaries = beneficiaryRepo.findByWallet(wallet.getWalletId());

		if(!beneficiaries.contains(beneficiary)) beneficiaryRepo.save(beneficiary);


		List<Customer> customers =  customerRepo.findCustomerByMobile(targetMobileNumber);

		if(customers.isEmpty()) {
			throw new CustomerException("Customer with mobile number "+ targetMobileNumber +" does not exist");
		}

		Wallet targetWallet = walletRepo.showCustomerWalletDetails(customers.get(0).getCustomerId());

		if(wallet.getBalance().compareTo(amount)<0) throw new WalletException("Add more amount in wallet for transaction");

		targetWallet.setBalance(targetWallet.getBalance().add(amount));
		walletRepo.save(targetWallet);

		wallet.setBalance(wallet.getBalance().subtract(amount));
		walletRepo.save(wallet);


		Transaction transaction = new Transaction("Bank transfer", LocalDate.now(),  amount.doubleValue(),amount +" transferred to "+ targetMobileNumber);
		transaction.setWallet(wallet);

		transactionService.addTransaction(transaction);

		return "Fund Transferred successfully";
	}


	/*---------------------------------------------   Deposit Amount  ------------------------------------------------*/
	@Override
	public String depositAmount(BigDecimal amount, Integer accountNo, String key) throws BankAccountException, CustomerException, WalletException, TransactionException {

		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession==null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Integer userId = currUserSession.getUserId();
		Wallet wallet = walletRepo.showCustomerWalletDetails(userId);

		List<BankAccount> accounts = bankAccountRepo.findAllByWallet(wallet.getWalletId());

		if(accounts.isEmpty()) {
			throw new BankAccountException("Add bank account for transaction");
		}

		BankAccount bankAccount = null;

		for(BankAccount b : accounts) {
			if((b.getAccountNo().toString()).equals(accountNo.toString())) {
				bankAccount = b;
				break;
			}

		}

		if(bankAccount==null){
			throw new BankAccountException("Bank account number does not match the data of saved accounts");
		}

		if(bankAccount.getBalance() < amount.doubleValue()) {
			throw new BankAccountException("Insufficient balance in account");
		}

		bankAccount.setBalance(bankAccount.getBalance() - amount.doubleValue());
		wallet.setBalance(wallet.getBalance().add(amount));

		bankAccountRepo.save(bankAccount);

		double value = amount.doubleValue();
		Transaction transaction = new Transaction("Bank transfer", LocalDate.now(), value,"transferred from bank "+bankAccount.getBankName()+" to wallet");
		transaction.setWallet(wallet);


		transactionService.addTransaction(transaction);


		return "Your bank account no "+ accountNo +" debited for "+ amount +" Rs" ;

	}


//	/*-------------------------------------------  View Customers Li   -----------------------------------------------*/
//	@Override
//	public List<Customer> getList(Customer customer, String key) throws CustomerException {
//		return null;
//	}


	/*---------------------------------------------   Update Account  ------------------------------------------------*/
	@Override
	public Customer updateAccount(Customer customer, String key) throws CustomerException {

		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession==null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Optional<Customer> customer1 = customerRepo.findById(currUserSession.getUserId());


		if(!customer1.isPresent()) {
			throw new CustomerException("Customer with given CustomerId not exist");
		}

		customer.setCustomerId(currUserSession.getUserId());

		return customerRepo.save(customer);
	}


	/*------------------------------------------   Add Money To Wallet  ----------------------------------------------*/
	@Override
	public String addMoney(Wallet wallet, Integer accountNo, BigDecimal amount, String key) throws WalletException, BankAccountException, CustomerException, TransactionException {

		CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
		if(currUserSession==null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Integer userId = currUserSession.getUserId();
		wallet = walletRepo.showCustomerWalletDetails(userId);

		List<BankAccount> accounts = bankAccountRepo.findAllByWallet(wallet.getWalletId());

		if(accounts.isEmpty()) {
			throw new BankAccountException("Add bank account for transaction");
		}

		BankAccount bankAccount = null;

		for(BankAccount b: accounts) {
			if((b.getAccountNo().toString()).equals(accountNo.toString())) {
				bankAccount = b;
				break;
			}

		}

		if(bankAccount == null){
			throw new BankAccountException("Bank account number does not match the data of saved accounts");
		}

		if(bankAccount.getBalance() < amount.doubleValue()) {
			throw new BankAccountException("Insufficient balance in account");
		}

		bankAccount.setBalance(bankAccount.getBalance() - amount.doubleValue());
		wallet.setBalance(wallet.getBalance().add(amount));

		bankAccountRepo.save(bankAccount);

		double value = amount.doubleValue();
		Transaction transaction = new Transaction("Bank transfer", LocalDate.now(), value,"transferred from bank "+bankAccount.getBankName()+" to wallet");
		transaction.setWallet(wallet);


		transactionService.addTransaction(transaction);


		return "Your bank account no "+ accountNo +" debited for "+ amount +" Rs" ;

	}

}
