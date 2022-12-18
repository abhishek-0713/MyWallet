package com.mywallet.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;
import com.mywallet.service.WalletService;

@RestController

public class WalletController {
	
	@Autowired
	public WalletService walletService ;
	
	@PostMapping("/createaccount")
	public ResponseEntity<Customer> CreateAccountCon(@Valid @RequestBody Customer customer) throws CustomerException{
		
		 Customer customers = walletService.createAccount(customer);
		
		return new ResponseEntity<Customer>(customers,HttpStatus.CREATED);
	}


	@PostMapping("/updateaccount")
	public ResponseEntity<Customer> updateCustomerDetails(@Valid @RequestBody Customer customer, @RequestParam String key) throws CustomerException{
		
		Customer updateCustomer = walletService.updateAccount(customer, key);
		
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/fundtransfer")
	public ResponseEntity<String> fundtransfer(@RequestParam("mobile") String targetMobileNumber, @RequestParam("name") String name, @RequestParam("amount") Double amount, @RequestParam("key") String key) throws WalletException, CustomerException, TransactionException{
		
		BigDecimal bigDecimal = BigDecimal.valueOf(amount);

		String msg = walletService.fundTransfer(name, targetMobileNumber, bigDecimal, key);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	@GetMapping("/showbalance")
	public ResponseEntity<BigDecimal> showWalletBalance(@RequestParam("mobile") String MobileNumber, @RequestParam("key") String key) throws CustomerException{
		
		BigDecimal balance = walletService.showBalance(MobileNumber, key);
		
		return new ResponseEntity<BigDecimal>(balance, HttpStatus.ACCEPTED);
	}
	
	
	
}
