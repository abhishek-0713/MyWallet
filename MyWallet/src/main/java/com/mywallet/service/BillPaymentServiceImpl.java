package com.mywallet.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;
import com.mywallet.repository.BillPaymentRepo;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private BillPaymentRepo billPaymentRepo;
	
	@Autowired
	private WalletService walletService;
	
	
//	@Autowired
//	private WalletRepo walletRepo;
//	@Autowired
//	private CustomerRepo customerRepo;
//	@Autowired
//	private CurrentSessionRepo currentSessionRepo;


	/*---------------------------------   Add BillPayment  -------------------------------------*/
	@Override
	public BillPayment addBillPayment(String key, int walletId, String recieverMobile, String Name, double amount,
			String BillType, LocalDate paymentDate) throws BillPaymentException, CustomerException, WalletException, TransactionException {
        
        
        BigDecimal amnt = BigDecimal.valueOf(amount);
		
        walletService.fundTransfer(Name, BillType, amnt, key);
		
		BillPayment newbill = new BillPayment();
		newbill.setAmount(amount);
		newbill.setBillType(BillType);
		newbill.setPaymentDate(LocalDate.now());
		
		
        return billPaymentRepo.save(newbill);
	}

	
	/*---------------------------------   View BillPayment  -------------------------------------*/	
	
	@Override
	public BillPayment viewBillPayment(BillPayment billPayment, String key) throws BillPaymentException {
		// TODO Auto-generated method stub
		return null;
	}




}
