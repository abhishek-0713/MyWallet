package com.mywallet.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	/* --------------------------------------   Login Exception    ----------------------------------------------*/
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(LoginException loginException,WebRequest request){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	/* --------------------------------------   BankAccount Exception    ----------------------------------------------*/
	
	@ExceptionHandler(BankAccountException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(BankAccountException bankAccountException,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), bankAccountException.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	/* --------------------------------------   Beneficiary Exception    ----------------------------------------------*/

	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(BeneficiaryException beneficiaryException ,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), beneficiaryException.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	/* --------------------------------------   BillPayment Exception    ----------------------------------------------*/

	@ExceptionHandler(BillPaymentException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(BillPaymentException billPaymentException,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), billPaymentException.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	/* --------------------------------------   Customer Exception    ----------------------------------------------*/

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(CustomerException customerException,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), customerException.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	/* --------------------------------------   BankAccount Exception    ----------------------------------------------*/

	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(TransactionException transactionException,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), transactionException.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	/* --------------------------------------   Wallet Exception    ----------------------------------------------*/

	@ExceptionHandler(WalletException.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(WalletException walletException,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), walletException.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	/* --------------------------------------   Exception    ----------------------------------------------*/

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> mywalletExceptionHandler(Exception exception,WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
}
