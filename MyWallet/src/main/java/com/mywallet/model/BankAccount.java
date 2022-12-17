package com.mywallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNumber;
	@NotNull
	private String bankName;
	@NotNull
	private String IFSCCode;
	@NotNull
	private double balance;
	                                                                                                                             
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Wallet wallet;

	public BankAccount(Integer accountNumber, @NotNull String iFSCCode, @NotNull String bankName,
			@NotNull double balance) {
		super();
		this.accountNumber = accountNumber;
		IFSCCode = iFSCCode;
		this.bankName = bankName;
		this.balance = balance;
	}

	
}
