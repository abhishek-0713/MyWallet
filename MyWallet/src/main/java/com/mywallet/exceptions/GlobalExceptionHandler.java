package com.mywallet.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	/* --------------------------------------   Login Exception    ----------------------------------------------*/
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(LoginException loginException,WebRequest request){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), loginException.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
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
	
	
	/* -------------------------------------- BeanDefinitionValidation  Exception    ----------------------------------------------*/
	@ExceptionHandler(BeanDefinitionValidationException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(BeanDefinitionValidationException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	/* --------------------------------------  IllegalArgument Exception    ----------------------------------------------*/
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(IllegalArgumentException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	/* -------------------------------------- NoHandlerFound  Exception    ----------------------------------------------*/
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(NoHandlerFoundException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	/* -------------------------------------- MethodArgumentNotValid  Exception    ----------------------------------------------*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(MethodArgumentNotValidException ee){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),"Validation Error", ee.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
}
