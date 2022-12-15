package com.mywallet.model;

import java.time.LocalDate;

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
public class BillPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	private String billType;
	private double amount;
	private LocalDate paymentDatel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	
}
