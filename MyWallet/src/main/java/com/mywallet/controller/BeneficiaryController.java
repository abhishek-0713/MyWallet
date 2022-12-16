package com.mywallet.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.model.Beneficiary;
import com.mywallet.service.BeneficiaryService;

@RestController
public class BeneficiaryController {
	
	@Autowired
	private BeneficiaryService beneficiaryService;

	@PostMapping("/beneficiary")
	public ResponseEntity<Beneficiary> addBeneficiaryHandler(@Valid @RequestBody Beneficiary beneficiary) throws BeneficiaryException{
		
		Beneficiary result = beneficiaryService.addBeneficiary(beneficiary);
		
		return new ResponseEntity<Beneficiary>(result,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/beneficiaries/{name}")
	public ResponseEntity<Beneficiary> deleteBeneficiaryHandler(@PathVariable("name") String name) throws BeneficiaryException{
		
		Beneficiary deleted = beneficiaryService.deleteBeneficiary(name);
		
		return new ResponseEntity<Beneficiary>(deleted,HttpStatus.OK);
		
		
	}
	
	
	
	@GetMapping("/beneficiary/{num}")
	public ResponseEntity<Beneficiary> viewBeneficiaryHandler(@Valid @PathVariable("num") String mobileNumber) throws BeneficiaryException{
		
		Beneficiary result = beneficiaryService.viewBeneficiary(mobileNumber);
		
		return new ResponseEntity<Beneficiary>(result,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/beneficiaries")
	public ResponseEntity<List<Beneficiary>> viewAllBeneficiaryHandler() throws BeneficiaryException{
		
		List<Beneficiary> beneficiaries = beneficiaryService.viewAllBeneficiary();
		
		return new ResponseEntity<List<Beneficiary>>(beneficiaries,HttpStatus.OK);
		
	}
	
	
}
