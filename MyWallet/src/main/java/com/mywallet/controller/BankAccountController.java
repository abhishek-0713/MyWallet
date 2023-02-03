package com.mywallet.controller;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BankAccount;
import com.mywallet.model.Wallet;
import com.mywallet.model.dto.BankAccountDTO;
import com.mywallet.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer/bankaccount")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;


	/*---------------------------------------   Add Bank Account Mapping -------------------------------------------*/
	@PostMapping("/add")
	public ResponseEntity<String> addAccountMapping(@RequestParam String key,@Valid @RequestBody BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException{
		
		bankAccountService.addBankAccount(key, bankAccountDTO);
		
		return new ResponseEntity<String>("Bank Account Added Successfully",HttpStatus.CREATED);
		
	}


	/*---------------------------------------   Delete Bank Account Mapping -------------------------------------------*/
	@DeleteMapping("/delete")
	public ResponseEntity<Wallet> removeAccountMapping(@RequestParam String key,@Valid @RequestBody BankAccountDTO bankAccount) throws BankAccountException, CustomerException{

		return new ResponseEntity<>(bankAccountService.removeBankAccount(key, bankAccount),HttpStatus.OK);
	}


	/*---------------------------------------   View Bank Account Mapping -------------------------------------------*/
	@GetMapping("/details")
	public ResponseEntity<Optional<BankAccount>> getBankAccountDetailsMapping(@RequestParam String key, @RequestParam Integer accountNo) throws BankAccountException, CustomerException{

		return new ResponseEntity<Optional<BankAccount>>(bankAccountService.viewBankAccount(key, accountNo),HttpStatus.OK);

	}


	/*---------------------------------------   View All Bank Account Mapping -------------------------------------------*/
	@GetMapping("/all")
	public ResponseEntity<List<BankAccount>> getAllBankAccountMapping(@RequestParam String key) throws BankAccountException, CustomerException{
		
		return new ResponseEntity<List<BankAccount>>(bankAccountService.viewAllBankAccounts(key),HttpStatus.FOUND);
		
	}


}