package com.mywallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.InsufficientFundException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;
import com.mywallet.service.BillPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BillPaymentController {

	

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private WalletRepo walletRepo;

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private BillPaymentService billPayService;


	@PostMapping("/addBillPayment")
	public ResponseEntity<BillPayment> addBillPayment(@RequestBody BillPayment billPayment, @RequestParam String key)throws  InsufficientFundException, BillPaymentException, WalletException, CustomerException, LoginException, TransactionException {
		
		BillPayment payment = billPayService.addBillPayment(billPayment, key);
		
		return new ResponseEntity<BillPayment>(payment, HttpStatus.CREATED);
	}

	@GetMapping("/viewAllpayments")
	public ResponseEntity<List<BillPayment>> viewAllpayments(@RequestBody BillPayment billPayment, @RequestParam String key) throws  WalletException, BillPaymentException, TransactionException, CustomerException, BankAccountException {
		
		List<BillPayment> billList = billPayService.viewBillPayment(billPayment, key);
		
		return new ResponseEntity<List<BillPayment>>(billList, HttpStatus.OK);
	}
}
