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
			wallet.setBalance(BigDecimal.valueOf(0));
		
			wallet.setCustomer(customer);
			walletRepo.save(wallet);
			
			return customerRepo.save(customer);
		}		
		throw new CustomerException("This mobile number is already registered with EZWallet");
	
	}

	
	/*---------------------------------   Show Wallet Balance  -------------------------------------*/
	@Override
	public Customer showBalance(String mobile, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	/*---------------------------------   Fund Transfer  -------------------------------------*/
	@Override
	public String fundTransfer(String srcMobileNumber, String targetMobileNumber, BigDecimal amount, String key)
			throws WalletException, TransactionException {
		// TODO Auto-generated method stub
		return null;
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

	
	/*---------------------------------   Update Account  -------------------------------------*/
	@Override
	public Customer updateAccount(Integer accno, Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Add Money To Wallet  -------------------------------------*/
	@Override
	public Customer addMoney(Wallet wallet, BigDecimal amount, String key) throws WalletException, BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
