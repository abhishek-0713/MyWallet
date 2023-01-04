package com.mywallet.controller;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Transaction;
import com.mywallet.model.dto.TransactionDTO;
import com.mywallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;


	/*----------------------------------------   Find Transaction - wallet  ------------------------------------------*/
	@PostMapping("/wallet")
	public ResponseEntity<List<TransactionDTO>> viewByWallet(@RequestParam String key) throws TransactionException, WalletException, CustomerException{

		List<Transaction> transactions= transactionService.findByWallet(key);

		List<TransactionDTO> transactionDTOS = new ArrayList<>();

		for(Transaction t:transactions) {

			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getTransactionType(), t.getTransactionDate(),t.getAmount(), t.getDescription() );
			transactionDTOS.add(transactionDTO);
		}
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOS,HttpStatus.OK);
	}


	/*-----------------------------------------   Find Transaction - tId ---------------------------------------------*/
	@GetMapping("/transactionId")
	public ResponseEntity<TransactionDTO> findById(@RequestParam String key, @RequestParam Integer transactionId) throws TransactionException, CustomerException{

		Transaction t = transactionService.findByTransactionId(key,transactionId);
		TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getTransactionType(), t.getTransactionDate(),t.getAmount(), t.getDescription() );


		return new ResponseEntity<TransactionDTO>(transactionDTO, HttpStatus.CREATED);
	}


	/*----------------------------------------   Find Transaction - Type  --------------------------------------------*/
	@GetMapping("/type")
	public ResponseEntity<List<TransactionDTO>> viewAllTransacationByType(@RequestParam String key, @RequestParam String type) throws TransactionException, CustomerException{

		List<Transaction> transactions = transactionService.findByTransactionType(key,type);

		List<TransactionDTO> transactionDTOS = new ArrayList<>();
		for(Transaction t:transactions) {

			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getTransactionType(), t.getTransactionDate(),t.getAmount(), t.getDescription() );

			transactionDTOS.add(transactionDTO);
		}
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOS, HttpStatus.ACCEPTED);

	}


	/*------------------------------------   View Transaction - Between 2 date ---------------------------------------*/
	@GetMapping("/between")
	public ResponseEntity<List<TransactionDTO>> viewByTwoDate(@RequestParam String key, @RequestParam("one") String one, @RequestParam("two")  String two) throws TransactionException, CustomerException{

		LocalDate firstDate= LocalDate.parse(one);
		LocalDate secondDate = LocalDate.parse(two);
		List<Transaction> transactions = transactionService.viewTransactionBetweenDate(key,firstDate, secondDate);
		
		List<TransactionDTO> transactionDTOS = new ArrayList<>();
		for(Transaction t:transactions) {

			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getTransactionType(), t.getTransactionDate(),t.getAmount(), t.getDescription() );

			transactionDTOS.add(transactionDTO);
		}
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOS, HttpStatus.ACCEPTED);
	
	}


	/*-----------------------------------------   View All Transaction  ----------------------------------------------*/
	@GetMapping("/all")
	public ResponseEntity<List<TransactionDTO>>  viewAllTransactionByAdmin() throws TransactionException{

		List<Transaction>  transactions = transactionService.viewAllTransaction();

		List<TransactionDTO> transactionDTOS = new ArrayList<>();

		for(Transaction t:transactions) {
			TransactionDTO transactionDTO = new TransactionDTO(t.getTransactionId(), t.getTransactionType(), t.getTransactionDate(),t.getAmount(), t.getDescription() );

			transactionDTOS.add(transactionDTO);
		}
		return new ResponseEntity<List<TransactionDTO>>(transactionDTOS, HttpStatus.OK);
	}


}
