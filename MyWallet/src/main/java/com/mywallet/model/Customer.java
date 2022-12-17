package com.mywallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer customerId;

	@NotNull
	@Size(min = 3, max = 15, message = "Name Contains 3-15 Characters")
	private String name;
	
	@NotNull
	@Size(min = 10, max = 10, message = "Mobile Number is Not Valid")
	private String mobileNumber;
	
	@NotNull
	@Size(min = 6,max = 12,message = "Password should contains 6-12 characters")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Wallet wallet;
}
