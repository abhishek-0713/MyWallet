package com.mywallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BankAccountException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.Customer;
import com.mywallet.model.Wallet;
import com.mywallet.repository.BankAccountRepo;
import com.mywallet.repository.BeneficiaryRepo;
import com.mywallet.repository.CustomerRepo;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private BankAccountRepo bankAccountRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	
	
	/*---------------------------------   Create Wallet Account  -------------------------------------*/
	@Override
	public Customer createAccount(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Show Wallet Balance  -------------------------------------*/
	@Override
	public Customer showBalance(String mobile) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	/*---------------------------------   Fund Transfer  -------------------------------------*/
	@Override
	public String fundTransfer(String srcMobileNumber, String targetMobileNumber, BigDecimal amount)
			throws WalletException, TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Deposit Amount  -------------------------------------*/
	@Override
	public Customer depositAmount(BigDecimal amount, Integer accno) throws BankAccountException, WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View Customers List   -------------------------------------*/
	@Override
	public List<Customer> getList(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Update Account  -------------------------------------*/
	@Override
	public Customer updateAccount(Integer accno, Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Add Money To Wallet  -------------------------------------*/
	@Override
	public Customer addMoney(Wallet wallet, BigDecimal amount) throws WalletException, BankAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
