package com.mywallet.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BeneficiaryDTO {

	@NotNull
	@Size(min = 10,message = "Enter Valid Mobile Number")
	private String beneficiaryMobile;
	
	@NotNull
	@Size(min = 3, max = 20,message ="Enter Valid Beneficiary Name")
	private String beneficiaryName;
    
}
