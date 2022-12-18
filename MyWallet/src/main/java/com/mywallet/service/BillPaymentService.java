package com.mywallet.service;

import java.time.LocalDate;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;

public interface BillPaymentService {

	public String addBillPayment(String targetMobile, String Name,double amount,String BillType,LocalDate paymentDate,int walletId,String key) throws BillPaymentException,WalletException,CustomerException,TransactionException, LoginException;
	
	public BillPayment viewBillPayment(BillPayment billPayment, String key) throws BillPaymentException;
}

