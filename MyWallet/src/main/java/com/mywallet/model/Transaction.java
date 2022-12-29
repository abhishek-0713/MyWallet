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
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer transactionId;

   private String transactionType;

   private LocalDate transactionDate;

   private double amount;

   private String Description;
   

   @ManyToOne(cascade = CascadeType.ALL)
   private Wallet wallet;

   public Transaction(String transactionType, LocalDate transactionDate, double amount, String description) {
      this.transactionType = transactionType;
      this.transactionDate = transactionDate;
      this.amount = amount;
      Description = description;
   }
}

