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
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;
import com.mywallet.service.BillPaymentService;

@RestController
public class BillPaymentController {

	@Autowired
	private BillPaymentService billPayService;
	
	@PostMapping("/addBillPayment")
	public ResponseEntity<BillPayment> addBillPayment(@RequestParam("targetMobile") String targetMobile, @RequestParam("Name") String Name, @RequestParam("amount") double amount, @RequestParam("BillType") String BillType, @RequestParam("key") String key) throws BillPaymentException, WalletException, CustomerException, TransactionException {
		
		LocalDate date=LocalDate.now();
		
		BillPayment billPayment = billPayService.addBillPayment(key, 0, key, Name, amount, BillType, date);
		
		return new ResponseEntity<BillPayment>(billPayment, HttpStatus.OK);
	}
}
