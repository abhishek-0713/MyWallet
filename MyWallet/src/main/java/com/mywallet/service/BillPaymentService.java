package com.mywallet.service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;

import java.time.LocalDate;

public interface BillPaymentService {

	public String addBillPayment(String targetMobile, String Name, double amount, String BillType, LocalDate paymentDate, Integer walletId, String key) throws BillPaymentException,WalletException,CustomerException,TransactionException;

}