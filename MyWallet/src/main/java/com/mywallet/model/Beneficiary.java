package com.mywallet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
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
	@Size(min = 10,message = "Enter Valid Mobile Number")
	private String beneficiaryMobile;
	
	@NotNull
	@Size(min = 3, max = 15,message ="Enter Valid Beneficiary Name")
	private String beneficiaryName;
	

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "walletId",referencedColumnName = "walletId")
	private Wallet wallet;

}
