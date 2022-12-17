package com.mywallet.service;

import java.util.List;
import java.util.Optional;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Wallet;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.CustomerRepo;
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
	private CustomerRepo customerRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;

	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	
	/*---------------------------------   Add Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException {

		Optional<Beneficiary> optional = beneficiaryRepo.findById(beneficiary.getBeneficiaryMobile());

		if(optional.isEmpty()) {
			return beneficiaryRepo.save(beneficiary);
		}
		throw new BeneficiaryException("Beneficiary Already Exist with Same Mobile Number");

	}


//	/*---------------------------------   Delete Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary deleteBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException, CustomerException {

		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		if(currentUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Wallet wallet = walletRepo.customerWalletDetailsByCId(currentUserSession.getUserId());

		Beneficiary beneficiaries = beneficiaryRepo.findByMobWallet(wallet.getWalletId(),beneficiary.getBeneficiaryMobile());

		if(beneficiaries == null) {
			throw new BeneficiaryException("No Beneficiary Registered Yet");
		}
		beneficiaryRepo.delete(beneficiaries);

		return beneficiaries;

	}

	
//	/*---------------------------------   View Beneficiary  -------------------------------------*/
	@Override
	public Beneficiary viewBeneficiary(String mobileNumber, String key) throws BeneficiaryException, CustomerException {

		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		if(currentUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Wallet wallet = walletRepo.customerWalletDetailsByCId(currentUserSession.getUserId());

		Beneficiary beneficiaries = beneficiaryRepo.findByNameWallet(wallet.getWalletId(),mobileNumber);

		if(beneficiaries == null) {
			throw new BeneficiaryException("No Beneficiary Registered Yet");
		}
		return beneficiaries;

	}

	
	/*---------------------------------   View All Beneficiary  -------------------------------------*/
	@Override
	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException {

		CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		if(currentUserSession == null) {
			throw new CustomerException("No Customer LoggedIn");
		}

		Wallet wallet = walletRepo.customerWalletDetailsByCId(currentUserSession.getUserId());

		List<Beneficiary> beneficiaries = beneficiaryRepo.findByWallet(wallet.getWalletId());
		if(beneficiaries.size() == 0) {
			throw new BeneficiaryException("No Beneficiary Registered Yet");
		}
		return beneficiaries;
	}
}
