package com.mywallet.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	
	@Min(value = 500,message = "Min 500")
	private BigDecimal balance;
	
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", balance=" + balance + "]";
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public Wallet(Integer walletId, @Min(value = 500, message = "Min 500") BigDecimal balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}
}
