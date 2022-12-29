package com.mywallet.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BeneficiaryDTO {

   @NotNull
   @Size(min = 10, max = 10 ,message = "Invalid Mobile Number [ 10 Digit Only ] ")
   private String beneficiaryMobileNumber;

   @NotNull
   @Size(min = 3, message = "Invalid Beneficiary name [ contains at least 3 characters ]")
   private String beneficiaryName;
   
}