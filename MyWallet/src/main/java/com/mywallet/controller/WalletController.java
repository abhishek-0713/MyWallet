package com.mywallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BankAccount;
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

	
	@PutMapping("/updateaccount")
	public ResponseEntity<Customer> updateAccount(@RequestBody Customer customer,@RequestParam(required=false) String key) throws CustomerException{
		
		Customer updateCustomer=walletService.updateAccount(customer, key);
		
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}

	
	@PutMapping("/depositamount/{accountNo}/{amount}")
	public ResponseEntity<BankAccount> depositAmount(@PathVariable("accountNo")Integer accountNo ,@PathVariable("amount") Double amount, String key) throws BankAccountException, WalletException{
		BankAccount ba=walletService.depositAmount(amount, accountNo, key);
		
		return new ResponseEntity<BankAccount>(ba,HttpStatus.ACCEPTED);
	}
	
	
}
