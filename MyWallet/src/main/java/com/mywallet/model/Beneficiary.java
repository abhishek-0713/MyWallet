package com.mywallet.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Beneficiary {

	@NotNull
	@Size(min = 10,message = "Enter Valid Mobile Number")
	private String mobile;
	@NotNull
	@Size(min = 3,max = 15,message ="Enter Valid User Name" )
	private String name;
	
	//We need to discuss Table relation?
//	private Wallet wallet;
	
	
	
}
