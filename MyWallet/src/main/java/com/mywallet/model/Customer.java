package com.mywallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
	@Size(min = 10,message = "Mobile Number is Not Valid")
	private String mobil;
	
	@Email(message = "Enter Valid Email Address")
	private String email;
	
	@NotNull
	private String address;
	
	@NotNull
	@Size(min = 6,max = 12,message = "Password should contains 6-12 characters")
	private String pass;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
}
