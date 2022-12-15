package com.mywallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.model.BillPayment;
import com.mywallet.repository.BillPaymentRepo;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private BillPaymentRepo billPaymentRepo;
	
	@Autowired
	private WalletService walletService;
	
	/*---------------------------------   Add BillPayment  -------------------------------------*/
	@Override
	public BillPayment addBillPayment(BillPayment billPayment) throws BillPaymentException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View BillPayment  -------------------------------------*/	
	
	@Override
	public BillPayment viewBillPayment(BillPayment billPayment) throws BillPaymentException {
		// TODO Auto-generated method stub
		return null;
	}

}
