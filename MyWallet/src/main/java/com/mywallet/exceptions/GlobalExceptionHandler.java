package com.mywallet.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(BankAccountException.class)
	public ResponseEntity<ErrorDetails> bankAccountException(BankAccountException bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<ErrorDetails> bankAccountException(BeneficiaryException bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BillPaymentException.class)
	public ResponseEntity<ErrorDetails> bankAccountException(BillPaymentException bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> bankAccountException(CustomerException bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorDetails> bankAccountException(TransactionException bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WalletException.class)
	public ResponseEntity<ErrorDetails> bankAccountException(WalletException bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> bankAccountException(Exception bae,WebRequest req){
		ErrorDetails ed=new ErrorDetails();
		ed.setDiscription(req.getDescription(false));
		ed.setMessage(bae.getMessage());
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
