package com.mywallet.service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.model.BillPayment;

public interface BillPaymentService {

	public BillPayment addBillPayment(BillPayment billPayment) throws BillPaymentException;
	
	public BillPayment viewBillPayment(BillPayment billPayment) throws BillPaymentException;
}
