package com.mywallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.Beneficiary;
import com.mywallet.model.dto.BeneficiaryDTO;
import com.mywallet.service.BeneficiaryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    
	/*----------------------------------------------- Add Beneficiary Mapping  ------------------------------------------------*/	

    @PostMapping("/beneficiary")
    public ResponseEntity<Beneficiary> addBeneneficiary(@RequestBody Beneficiary beneficiary,  @RequestParam String key) throws BeneficiaryException {
        
    	return new ResponseEntity<Beneficiary>(beneficiaryService.addBeneficiary(beneficiary,key), HttpStatus.CREATED);
    }


    
	/*----------------------------------------------- Delete Beneficiaries Mapping  ------------------------------------------------*/	

    @DeleteMapping("/beneficiary")
    public ResponseEntity<Beneficiary> deleteBeneneficiary(@Valid @RequestBody BeneficiaryDTO beneficiaryDTO , @RequestParam String key) throws BeneficiaryException, CustomerException, CustomerException {
        
    	return new ResponseEntity<Beneficiary>(beneficiaryService.deleteBeneficiary(beneficiaryDTO, key),HttpStatus.OK);
    }

    
    
	/*----------------------------------------------- View All Beneficiaries Mapping  ------------------------------------------------*/	

    @GetMapping("/beneficiaries")
    public ResponseEntity<List<Beneficiary>> getAllBeneneficiary(@RequestParam String key) throws BeneficiaryException, CustomerException{
        
    	return new ResponseEntity<List<Beneficiary>>(beneficiaryService.viewAllBeneficiary(key),HttpStatus.FOUND);
    }

}
