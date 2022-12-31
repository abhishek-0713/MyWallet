package com.mywallet.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BankAccountDTO {

	@NotNull
	private Integer accountNo;

	@NotNull
	@Size(min = 5, max = 10,message = "Invalid IFSC Code [ 5-10 Characters only ]")
	private String IFSCCode;

	@NotNull
	@Size(min = 3, max = 15,message = "Invalid Bank Name [ 3-15 characters only ]")
	private String bankName;

	@NotNull
	private Double balance;

}
