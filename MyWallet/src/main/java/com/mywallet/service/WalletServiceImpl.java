package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.CustomerException;
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

	

}
