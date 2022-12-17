package com.mywallet.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {

    private Integer transactionId;
    private double amount;
    private String transactionType;
    private String Description;
    private LocalDate transactionDate;

}
