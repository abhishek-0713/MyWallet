package com.mywallet.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

   private Integer transactionId;

   private String transactionType;

   private LocalDate transactionDate;

   private double amount;

   private String Description;

}