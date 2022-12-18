package com.mywallet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private String mobile;
	
	@NotNull
	@Size(min = 3, max = 15,message ="Enter Valid User Name")
	private String name;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "walletId")
	private List<Wallet> walletList = new ArrayList<>();

	
	private Integer walletId;
	
	
}
