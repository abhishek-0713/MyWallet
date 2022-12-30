package com.mywallet.service;

import com.mywallet.exceptions.BillPaymentException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.BillPayment;
import com.mywallet.repository.BillPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private BillPaymentRepo billPaymentRepo;


	/*--------------------------------------------   Add Bill Payment -------------------------------------------------*/
	@Override
	public String addBillPayment(String targetMobile, String Name, double amount, String billType, LocalDate paymentDate, Integer walletId, String key) throws BillPaymentException  {

		BigDecimal value = BigDecimal.valueOf(amount);

//		String str = walletService.fundTransfer(targetMobile, Name, value, key);

		BillPayment billPayment = new BillPayment(amount, billType, LocalDate.now());

		billPaymentRepo.save(billPayment);

//		return str;

		return "";
	}
}
