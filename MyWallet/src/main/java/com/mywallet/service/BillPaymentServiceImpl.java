package com.mywallet.service;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.model.BillPayment;
import com.mywallet.repository.BillPaymentRepo;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private BillPaymentRepo billPaymentRepo;
	@Autowired
	private WalletService walletService;
	@Autowired
	private WalletRepo walletRepo;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private CurrentSessionRepo currentSessionRepo;


	/*---------------------------------   Add BillPayment  -------------------------------------*/
	@Override
	public BillPayment addBillPayment(BillPayment billPayment, String key) throws BillPaymentException, CustomerException {
		return billPayment;
	}

	
	/*---------------------------------   View BillPayment  -------------------------------------*/	
	
	@Override
	public BillPayment viewBillPayment(BillPayment billPayment, String key) throws BillPaymentException {
		// TODO Auto-generated method stub
		return null;
	}

}
