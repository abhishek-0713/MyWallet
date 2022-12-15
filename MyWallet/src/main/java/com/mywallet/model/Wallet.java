package com.mywallet.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	
	@Min(value = 500, message = "Wallet Required Rs.500 Minimum Balance")
	private BigDecimal balance;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<Transaction> transactions = new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BillPayment> billPayments = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BankAccount> bankAccounts = new ArrayList<>();
	
	
	
}
