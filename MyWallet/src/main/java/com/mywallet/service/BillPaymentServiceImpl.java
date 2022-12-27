package com.mywallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.LoginException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;
import com.mywallet.repository.BillPaymentRepo;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private BillPaymentRepo billPaymentRepo;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	
	/*---------------------------------   Add BillPayment  -------------------------------------*/
	@Override
	public BillPayment addBillPayment(BillPayment billPayment, String key)
			throws BillPaymentException, WalletException, CustomerException, LoginException, TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View BillPayment  -------------------------------------*/	
	@Override
	public List<BillPayment> viewBillPayment(BillPayment billPayment, String key)
			throws BillPaymentException, TransactionException, CustomerException, BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
