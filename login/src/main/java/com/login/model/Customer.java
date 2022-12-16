package com.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer customerId;

	@Size(min = 10, max = 10, message = "Mobile Number is Not Valid")
	private String mobileNumber;
	
	@NotNull(message = "Please Enter the valid name")
	@Size(min = 3, message = "Please Enter the valid name")
	private String name;
	
	@NotNull
	@Size(min = 6, max = 12, message = "Password should contain  6 to 8 characters")
	private String password;		
	
	
	
}
