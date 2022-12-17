package com.mywallet.service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.BillPayment;

public interface BillPaymentService {

	public BillPayment addBillPayment(BillPayment billPayment, String key) throws BillPaymentException, CustomerException;
	
	public BillPayment viewBillPayment(BillPayment billPayment, String key) throws BillPaymentException;
}
