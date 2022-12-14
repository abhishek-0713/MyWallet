package com.mywallet.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BillPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	private String billType;
	private double amount;
	private LocalDate paymentDatel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	public BillPayment() {
		// TODO Auto-generated constructor stub
	}

	public BillPayment(Integer billId, String billType, double amount, LocalDate paymentDatel, Wallet wallet) {
		super();
		this.billId = billId;
		this.billType = billType;
		this.amount = amount;
		this.paymentDatel = paymentDatel;
		this.wallet = wallet;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDatel() {
		return paymentDatel;
	}

	public void setPaymentDatel(LocalDate paymentDatel) {
		this.paymentDatel = paymentDatel;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "BillPayment [billId=" + billId + ", billType=" + billType + ", amount=" + amount + ", paymentDatel="
				+ paymentDatel + ", wallet=" + wallet + "]";
	}
}
