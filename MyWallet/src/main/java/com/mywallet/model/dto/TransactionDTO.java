package com.mywallet.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TransactionDTO {


	private Integer transactionId;
    private double amount;
    private String transactionType;
    private String Description;
    private LocalDate transactionDate;
    


	public TransactionDTO(Integer transactionId, double amount, String transactionType, String description,
			LocalDate transactionDate) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
		Description = description;
		this.transactionDate = transactionDate;
	}

}
