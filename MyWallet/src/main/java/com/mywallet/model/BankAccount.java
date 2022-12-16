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
	private String IFSCCode;
	
	@NotNull
	private String BankName;
	
	@NotNull
	private double Balance;
	                                                                                                                             
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
}
