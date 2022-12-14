package com.mywallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accNumber;
	
	@NotNull
	private String IFSCCode;
	
	@NotNull
	private String BankName;
	@NotNull
	private double Balance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	public BankAccount() {
	  // TODO Auto-generated constructor stub
	}

	public BankAccount(Integer accNumber, @NotNull String iFSCCode, @NotNull String bankName, @NotNull double balance,
			Wallet wallet) {
		super();
		this.accNumber = accNumber;
		IFSCCode = iFSCCode;
		BankName = bankName;
		Balance = balance;
		this.wallet = wallet;
	}

	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "BankAccount [accNumber=" + accNumber + ", IFSCCode=" + IFSCCode + ", BankName=" + BankName
				+ ", Balance=" + Balance + ", wallet=" + wallet + "]";
	}
}
