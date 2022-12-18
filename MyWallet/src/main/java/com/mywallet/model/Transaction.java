package com.mywallet.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private double amount;
	private String transactionType;
	private String Description;
	private LocalDate transactionDate;

	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "walletId", referencedColumnName = "walletId")
	private Wallet wallet;
	

	public Transaction(LocalDate transactionDate, String transactionType, double amount, String description) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		Description = description;
		this.transactionDate = transactionDate;
	}

}
