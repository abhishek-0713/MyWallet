package com.mywallet.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Transaction;
import com.mywallet.model.dto.TransactionDTO;
import com.mywallet.service.TransactionService;


@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping("/transaction/between/")
	public ResponseEntity<List<TransactionDTO>> viewByTwoDate(@RequestParam String key, @RequestParam String start, @RequestParam  String end) throws TransactionException, CustomerException{
		
		LocalDate startDate = LocalDate.parse(start);
		LocalDate endDate = LocalDate.parse(end);
		
		List<Transaction> transactions = transactionService.viewTransactionsByDate(startDate, endDate, key);
		
		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		
		for(Transaction t:transactions) {
			
			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getAmount(), t.getTransactionType(),  t.getDescription(),  t.getTransactionDate());

			transactionDTOs.add(transactionDTO);	
		}
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOs, HttpStatus.ACCEPTED);
	
	}
	
	
	
	@PostMapping("/alltransactions")
	public ResponseEntity<List<TransactionDTO>> viewByWallet(@RequestParam String key) throws TransactionException, WalletException, CustomerException{
		
		List<Transaction> transactions = transactionService.viewAllTransaction();
		

		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		
		for(Transaction t:transactions) {
			
			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getAmount(), t.getTransactionType(),  t.getDescription(),  t.getTransactionDate());

			transactionDTOs.add(transactionDTO);	
		}
		
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOs, HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping("/transactions/type/{type}")
	public ResponseEntity<List<TransactionDTO>> viewAllTransacationByType(@RequestParam String key, @PathVariable("type") String type) throws TransactionException, CustomerException{
		
		List<Transaction> transactions = transactionService.viewAllTransactionByType(type, key);
		

		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		
		for(Transaction t:transactions) {
			
			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getAmount(), t.getTransactionType(),  t.getDescription(),  t.getTransactionDate());

			transactionDTOs.add(transactionDTO);	
		}
		
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOs, HttpStatus.ACCEPTED);
	
	}
	
	

	@GetMapping("/transactionbydate/{date}")
	public ResponseEntity<List<TransactionDTO>> viewByDate(@RequestParam String key, @RequestParam("date") String date) throws TransactionException, CustomerException{
		
		LocalDate startDate = LocalDate.parse(date);
		
		List<Transaction> transactions =  transactionService.viewTransactionsByDate(startDate, startDate, key);
		

		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		
		for(Transaction t:transactions) {
			
			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getAmount(), t.getTransactionType(),  t.getDescription(),  t.getTransactionDate());

			transactionDTOs.add(transactionDTO);	
		}
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOs, HttpStatus.ACCEPTED);
	}
	
}
