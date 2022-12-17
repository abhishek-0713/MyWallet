package com.mywallet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Transaction;
import com.mywallet.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService tService;
	
	
	@GetMapping("/getTransaction/{key}")
	public ResponseEntity<List<Transaction>> getAllTransaction(@PathVariable("key") String key) throws TransactionException, WalletException{

		List<Transaction> list = tService.viewAllTransaction(key);
		
		return new ResponseEntity<>(list,HttpStatus.OK);

	}
	
	@GetMapping("/getTransactionByDate/{key}/{date}")
	public ResponseEntity<List<Transaction>> getAllTransactionByDate(@PathVariable("key") String key,@PathVariable("date") LocalDate date) throws TransactionException, WalletException{
		
		List<Transaction> list = tService.viewTransactionsByDate(date, key);
		
		return new ResponseEntity<List<Transaction>>(list,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getTransactionByType/{key}/{type}")
	public ResponseEntity<List<Transaction>> getAllTransactionByType(@PathVariable("key") String key,@PathVariable("type") String type) throws TransactionException, WalletException{
		List<Transaction> list = tService.viewAllTransactionByType(type, key);
		
		return new ResponseEntity<List<Transaction>>(list,HttpStatus.ACCEPTED);
	}
	
	
	
}
