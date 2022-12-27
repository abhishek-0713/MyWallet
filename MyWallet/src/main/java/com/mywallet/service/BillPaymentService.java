package com.mywallet.service;

import java.time.LocalDate;
import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;

public interface BillPaymentService {

	
	public BillPayment addBillPayment(BillPayment billPayment,String key) throws BillPaymentException,WalletException,CustomerException,LoginException,TransactionException;
	
	public List<BillPayment> viewBillPayment(BillPayment billPayment, String key) throws BillPaymentException, TransactionException, CustomerException, BankAccountException;
}
