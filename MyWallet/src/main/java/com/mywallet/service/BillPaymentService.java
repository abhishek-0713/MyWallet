package com.mywallet.service;

import java.time.LocalDate;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;

public interface BillPaymentService {

	public BillPayment addBillPayment(String key, int walletId, String recieverMobile, String Name, double amount, String BillType, LocalDate paymentDate) throws BillPaymentException, CustomerException, WalletException, TransactionException;
	
	public BillPayment viewBillPayment(BillPayment billPayment, String key) throws BillPaymentException;
}
