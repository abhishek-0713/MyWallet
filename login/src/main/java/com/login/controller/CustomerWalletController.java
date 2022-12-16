package com.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.exception.CustomerException;
import com.login.model.Customer;
import com.login.service.WalletService;



@RestController
public class CustomerWalletController {
	
	@Autowired
	public WalletService walletService;

	@PostMapping("/createaccount")
	public ResponseEntity<Customer> createAccount(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer cust = walletService.createCustomerAccount(customer);
		
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
//	@PostMapping("/transfermoneyfrombanktowallet")
//	public ResponseEntity<String> transferMoneyFromBankToWallet(@RequestParam("accountno") Integer accountNo, @RequestParam("amount") Double amount, @RequestParam("key") String key) throws BankAccountException, CustomerException, TransactionException, WalletException{
//		
//		String msg = walletService.addMoneyFromBankToWallet(accountNo, amount, key);
//		
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//	}
//	
//	
//	@PostMapping("/fundtransfer")
//	public ResponseEntity<String> fundtransfer(@RequestParam("mobile") String mobile, @RequestParam("name") String name, @RequestParam("amount") Double amount, @RequestParam("key") String key) throws WalletException, CustomerException, TransactionException{
//		BigDecimal val = BigDecimal.valueOf(amount);
//		String msg = walletService.fundTransferToAnotherMobileNumber(mobile, name, val, key);
//		
//		return new ResponseEntity<String>(msg, HttpStatus.OK);
//	}
//	
//	@GetMapping("/walletbalance")
//	public ResponseEntity<BigDecimal> showWalletBalance(@RequestParam("key") String key) throws CustomerException{
//		
//		BigDecimal balance = walletService.showWalletBalance(key);
//		
//		return new ResponseEntity<BigDecimal>(balance, HttpStatus.ACCEPTED);
//	}
//	
//	@PostMapping("/updateaccount")
//	public ResponseEntity<Customer> updateCustomerDetails(@Valid @RequestBody Customer customer, @RequestParam("key") String key) throws CustomerException{
//		
//		Customer cust = walletService.updateCustomerDetails(customer, key);
//		
//		return new ResponseEntity<Customer>(cust, HttpStatus.ACCEPTED);
//	}
	
	
	
}
