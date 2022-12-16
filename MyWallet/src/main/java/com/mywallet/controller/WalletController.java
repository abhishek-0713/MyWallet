package com.mywallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.Customer;
import com.mywallet.service.WalletService;

@RestController
@RequestMapping("/customers")
public class WalletController {

	@Autowired
	public WalletService walletService;

	@PostMapping("/createaccount")
	public ResponseEntity<Customer> createAccount(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer createCustomerAccount = walletService.createAccount(customer);
		
		return new ResponseEntity<Customer>(createCustomerAccount, HttpStatus.CREATED);
	}
	
	
}
