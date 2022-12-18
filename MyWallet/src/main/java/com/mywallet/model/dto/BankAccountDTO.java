package com.mywallet.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BankAccountDTO {
	
	@NotNull
	private Integer accountNo;
	
	@NotNull
	private String IFSCCode;
	
	@NotNull
	private String bankName;
	
	@NotNull
	private Double balance;
	
	
}
