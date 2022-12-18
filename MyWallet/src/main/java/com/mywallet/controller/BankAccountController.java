package com.mywallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;
import com.mywallet.model.dto.BankAccountDTO;
import com.mywallet.service.AccountService;


@RestController
public class BankAccountController {
	
	@Autowired
	private AccountService accountService;
	
	/*------------------------------------------------ Add Bank Account Controller   ------------------------------------------------*/	
	
	@PostMapping("/bankaccounts")
	public ResponseEntity<String> addAccount(@RequestParam String key, @Valid @RequestBody BankAccountDTO bankAccount) throws BankAccountException, CustomerException{
		
		accountService.addAccount(key,bankAccount);
		
		return new ResponseEntity<String>("Bank Account Added Successfully", HttpStatus.CREATED);
		
	}


	/*----------------------------------------------- view All Bank Account Controller  ------------------------------------------------*/	

	@GetMapping("/bankaccounts")
	public ResponseEntity<List<BankAccount>> getAllBankAccount(@RequestParam String key) throws BankAccountException, CustomerException{
		
		return new ResponseEntity<List<BankAccount>>(accountService.viewAllAccount(key), HttpStatus.OK);
		
	}


	/*----------------------------------------------- Delete Bank Account Controller   ------------------------------------------------*/	

	@DeleteMapping("/bankaccounts")
	public ResponseEntity<Wallet> removeAccount(@RequestParam String key, @Valid @RequestBody BankAccountDTO bankAccount) throws BankAccountException, CustomerException{
		
		return new ResponseEntity<Wallet>(accountService.removeAccount(key,bankAccount), HttpStatus.OK);
	}
	

}
