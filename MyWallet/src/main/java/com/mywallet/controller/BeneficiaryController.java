package com.mywallet.controller;

import com.mywallet.exceptions.BeneficiaryException;
import com.mywallet.exceptions.CustomerException;
import com.mywallet.model.Beneficiary;
import com.mywallet.service.BeneficiaryService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BeneficiaryController {

    @Autowired
    BeneficiaryService beneficiaryService;

    @PostMapping("/addbeneficiary")
    public ResponseEntity<Beneficiary> addBeneneficiary(@RequestBody Beneficiary beneficiary,  @RequestParam String key) throws BeneficiaryException {
        return new ResponseEntity<Beneficiary>(beneficiaryService.addBeneficiary(beneficiary,key), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/beneficiaries")
    public ResponseEntity<Beneficiary> deleteBeneneficiary(@Valid @RequestBody Beneficiary beneficiary , @RequestParam String key) throws BeneficiaryException, CustomerException, CustomerException {
        return new ResponseEntity<Beneficiary>(beneficiaryService.deleteBeneficiary(beneficiary,key),HttpStatus.OK);
    }

    @GetMapping("/beneficiaries")
    public ResponseEntity<List<Beneficiary>> getAllBeneneficiaryMapping(@RequestParam String key) throws BeneficiaryException, CustomerException{
        return new ResponseEntity<List<Beneficiary>>(beneficiaryService.viewAllBeneficiary(key),HttpStatus.FOUND);
    }

}
