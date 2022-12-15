package com.mywallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.model.Beneficiary;
import com.mywallet.model.Customer;
import com.mywallet.repository.BeneficiaryRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	/*---------------------------------   Add Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary) throws BeneficiaryException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   Delete Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary deleteBeneficiary(Beneficiary beneficiary) throws BeneficiaryException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary viewBeneficiary(String mobileNumber) throws BeneficiaryException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*---------------------------------   View All Beneficiary  -------------------------------------*/
	@Override
	public List<Beneficiary> viewAllBeneficiary(Customer cutomer) throws BeneficiaryException {
		// TODO Auto-generated method stub
		return null;
	}

}
