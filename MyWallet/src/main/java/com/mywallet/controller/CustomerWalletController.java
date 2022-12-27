package com.mywallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.Customer;
import com.mywallet.service.WalletService;


@RestController
public class CustomerWalletController {
	
	@Autowired
	public WalletService walletService;

	@PostMapping("/createaccount")
	public ResponseEntity<Customer> createAccountMapping(@Valid @RequestBody Customer customer) throws CustomerException{
		
		return new ResponseEntity<Customer>(walletService.createCustomerAccount(customer), HttpStatus.CREATED);
	}
	
	
}
