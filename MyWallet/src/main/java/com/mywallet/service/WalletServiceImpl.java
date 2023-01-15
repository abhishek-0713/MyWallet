package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
		
	@Autowired
	public CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	public CurrentSessionRepo user;
	

	/*---------------------------------   Create Wallet Account  -------------------------------------*/
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


	@Override
	public BigDecimal showBalance(String mobile, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String fundTransfer(String name, String targetMobileNumber, BigDecimal amount, String key)
			throws WalletException, TransactionException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String depositAmount(BigDecimal amount, Integer accountNo, String key)
			throws BankAccountException, WalletException, CustomerException, TransactionException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer updateAccount(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String addMoney(Wallet wallet, Integer accountNo, BigDecimal amount, String key)
			throws WalletException, BankAccountException, CustomerException, TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
