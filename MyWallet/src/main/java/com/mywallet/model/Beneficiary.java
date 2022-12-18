package com.mywallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {

	@Id
	@NotNull
	@Size(min = 10,message = "Enter Valid beneficiary Mobile Number")
	private String beneficiaryMobile;
	
	@NotNull
	@Size(min = 3, max = 20,message ="Enter Valid Beneficiary Name")
	private String beneficiaryName;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "walletId",referencedColumnName = "walletId")
	private Wallet wallet;

}
