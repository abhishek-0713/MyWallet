package com.mywallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
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
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, @NotNull @Size(min = 10, message = "Mobile Number is Not Valid") String mobil,
			@Email(message = "Enter Valid Email Address") String email, @NotNull String address,
			@NotNull @Size(min = 6, max = 12, message = "Password should contains 6-12 characters") String pass) {
		super();
		this.customerId = customerId;
		this.mobil = mobil;
		this.email = email;
		this.address = address;
		this.pass = pass;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", mobil=" + mobil + ", email=" + email + ", address=" + address
				+ ", pass=" + pass + "]";
	}
}
