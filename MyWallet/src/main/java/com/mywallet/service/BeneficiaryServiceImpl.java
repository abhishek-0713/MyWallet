package com.mywallet.service;

import java.util.List;
import java.util.Optional;

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
		
		return beneficiaryRepo.save(beneficiary);
		
	}

	
//	/*---------------------------------   Delete Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary deleteBeneficiary(String name) throws BeneficiaryException {
	
		 Optional<Beneficiary> res= beneficiaryRepo.findByName(name);
		 
		 if (res.isPresent()) {

				Beneficiary result = res.get();

				beneficiaryRepo.delete(result);

				return result;

			} else {
				
				throw new BeneficiaryException("Name is not Present .. ");

			}
		
		
	}

	
//	/*---------------------------------   View Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary viewBeneficiary(String mobileNumber) throws BeneficiaryException {
		
		 Optional<Beneficiary> res= beneficiaryRepo.findById(mobileNumber);
		 
		 if(res.isPresent()) {
			 return res.get();
		 }else {
			 throw new BeneficiaryException("Number Not Found...");
		 }
		
	}

	
	/*---------------------------------   View All Beneficiary  -------------------------------------*/
	@Override
	public List<Beneficiary> viewAllBeneficiary() throws BeneficiaryException {
		  
		return beneficiaryRepo.findAll();
		
	}

}
