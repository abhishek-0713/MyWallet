package com.mywallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {

	@Id
	@NotNull
	private Integer accountNo;
	
	@NotNull
	private String IFSCCode;
	
	@NotNull
	private String bankName;
	
	@NotNull
	private Double balance;
	
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Wallet wallet;


	public BankAccount(@NotNull Integer accountNo, @NotNull String iFSCCode,
			@NotNull @Size(min = 4, max = 10, message = "Bank name not valid") String bankName,
			@NotNull Double balance) {
		super();
		this.accountNo = accountNo;
		IFSCCode = iFSCCode;
		this.bankName = bankName;
		this.balance = balance;
	}

}
