package com.mywallet.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.service.BillPaymentService;


@RestController
public class BillPaymentController {

	@Autowired
	private BillPaymentService billPayService;
	
	@PostMapping("/addBillPayment")
	public ResponseEntity<String> addBillPayment(@RequestParam("targetMobile") String targetMobile, @RequestParam("Name") String Name, @RequestParam("amount") double amount, @RequestParam("BillType") String BillType, @RequestParam("key") String key) throws BillPaymentException, WalletException, CustomerException, LoginException, TransactionException {
		
		LocalDate date=LocalDate.now();
		String output = billPayService.addBillPayment(targetMobile, Name, amount, BillType, date, 0, key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
}
