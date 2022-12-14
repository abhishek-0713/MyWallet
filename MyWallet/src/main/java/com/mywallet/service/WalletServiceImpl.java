package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;

public class WalletServiceImpl implements WalletService {

	@Override
	public Customer createAccount(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showBalance(String mobile) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fundTransfer(String srcMobileNumber, String targetMobileNumber, BigDecimal amount)
			throws WalletException, TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositAmount(BigDecimal amount, Integer accno) throws BankAccountException, WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getList(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateAccount(Integer accno, Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addMoney(Wallet wallet, BigDecimal amount) throws WalletException, BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
