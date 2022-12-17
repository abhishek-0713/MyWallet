package com.mywallet.service;

import java.util.List;

import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.Beneficiary;
import com.mywallet.model.Customer;

public interface BeneficiaryService {

	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException;

	public Beneficiary deleteBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException, CustomerException;
	
	public Beneficiary viewBeneficiary(String mobileNumber, String key) throws BeneficiaryException, CustomerException;
	
	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException;

	
}
