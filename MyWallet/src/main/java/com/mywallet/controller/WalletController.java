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
	WalletService walletService ;
	
	
	/*-----------------------------------------------  Create Account Mapping  ------------------------------------------------*/	

	@PostMapping("/createaccount")
	public ResponseEntity<Customer> CreateAccount(@Valid @RequestBody Customer customer) throws CustomerException{
		
		return new ResponseEntity<Customer>(walletService.createAccount(customer),HttpStatus.CREATED);
	}


	/*-----------------------------------------------  Update Account Mapping  ------------------------------------------------*/	

	@PostMapping("/updateaccount")
	public ResponseEntity<Customer> updateCustomerDetails(@Valid @RequestBody Customer customer, @RequestParam String key) throws CustomerException{
		
		return new ResponseEntity<Customer>(walletService.updateAccount(customer, key), HttpStatus.ACCEPTED);
	}
	
	/*-----------------------------------------------  Fund Transfer Mapping  ------------------------------------------------*/	

	@PostMapping("/fundtransfer")
	public ResponseEntity<String> fundtransfer(@RequestParam String targetMobileNumber, @RequestParam String name, @RequestParam Double amount, @RequestParam String key) throws WalletException, CustomerException, TransactionException{
		
		BigDecimal bigDecimal = BigDecimal.valueOf(amount);
		
		return new ResponseEntity<String>(walletService.fundTransfer(name, targetMobileNumber, bigDecimal, key), HttpStatus.ACCEPTED);
	}
	
	
	/*-----------------------------------------------  Show Wallet Balance Mapping  ------------------------------------------------*/	

	@GetMapping("/showbalance")
	public ResponseEntity<BigDecimal> showWalletBalance(@RequestParam String MobileNumber, @RequestParam String key) throws CustomerException{
		
		return new ResponseEntity<BigDecimal>(walletService.showBalance(MobileNumber, key), HttpStatus.OK);
	}
	
	
	
}
