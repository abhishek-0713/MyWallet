package com.mywallet.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.exceptions.CustomerException;
import com.mywallet.exceptions.TransactionException;
import com.mywallet.exceptions.WalletException;
import com.mywallet.model.CurrentUserSession;
import com.mywallet.model.Transaction;
import com.mywallet.model.Wallet;
import com.mywallet.repository.CurrentSessionRepo;
import com.mywallet.repository.TransactionRepo;
import com.mywallet.repository.WalletRepo;

@Service
public class TransactionServiceImpl implements TransactionService{

   @Autowired
   private CurrentSessionRepo currentSessionRepo;

   @Autowired
   private TransactionRepo transactionRepository;
   
   @Autowired
   private WalletRepo walletRepository;

   /*--------------------------------------------   Add Transaction  ------------------------------------------------*/
   @Override
   public Transaction addTransaction(Transaction tran) throws TransactionException, WalletException { 
      Optional<Wallet> wallet=   walletRepository.findById(tran.getWallet().getWalletId());
      if(!wallet.isPresent())throw new WalletException("Wallet id worng.");
      if(transactionRepository.save(tran) != null)return tran;
          throw new TransactionException("Data is null");
   }


   /*----------------------------------------   Find Transaction - wallet  ------------------------------------------*/
   @Override
   public List<Transaction> findByWallet(String key) throws TransactionException, WalletException, CustomerException {

      CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
      if(currUserSession==null) {
         throw new CustomerException("No Customer LoggedIn");
      }

      Wallet wallet = walletRepository.showCustomerWalletDetails(currUserSession.getUserId());

      Optional<Wallet> optional = walletRepository.findById(wallet.getWalletId());
      if(!optional.isPresent()){
         throw new WalletException("Invalid walletId");
      }

      List<Transaction> transactions = transactionRepository.findByWallet(wallet.getWalletId());
      if(transactions.isEmpty()){
         throw new TransactionException("No Transactions to Show");
      }
      return transactions;
   }


   /*-----------------------------------------   Find Transaction - tId ---------------------------------------------*/
   @Override
   public Transaction findByTransactionId(String key, Integer transactionId) throws TransactionException, CustomerException {

      CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
      if(currUserSession==null) {
         throw new CustomerException("No Customer LoggedIn");
      }

      Optional<Transaction> transaction = transactionRepository.findById(transactionId);

      if(!transaction.isPresent()){
         throw new TransactionException("Invalid transactionId");
      }
      return transaction.get();

   }


   /*----------------------------------------   Find Transaction - Type  --------------------------------------------*/
   @Override
   public List<Transaction> findByTransactionType(String key, String transactionType) throws TransactionException, CustomerException {

      CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
      if(currUserSession==null) {
         throw new CustomerException("No Customer LoggedIn");
      }

      List<Transaction> transactions = transactionRepository.findByTransactionType(transactionType);
      if(transactions.isEmpty()){
         throw new TransactionException("No Transactions to Show");
      }
      return transactions;
   }


   /*------------------------------------   View Transaction - Between 2 date ---------------------------------------*/
   @Override
   public List<Transaction> viewTransactionBetweenDate(String key, LocalDate startDate, LocalDate endDate) throws TransactionException, CustomerException {

      CurrentUserSession currUserSession = currentSessionRepo.findByUuid(key);
      if(currUserSession==null) {
         throw new CustomerException("No Customer LoggedIn");
      }

      LocalDate localDate = LocalDate.now();
      if(startDate.isAfter(localDate)){
         throw new TransactionException("Invalid Start Date [ Future Date ]");
      }
      if(endDate.isAfter(localDate)){
         throw new TransactionException("Invalid End Date [ Future Date ]");
      }
      if(startDate.isAfter(endDate)) {
         throw new TransactionException("Invalid Start Date ");
      }

      List<Transaction> transactions= transactionRepository.findByTransactionDateBetween(startDate, endDate);
      if(transactions.isEmpty()){
         throw new TransactionException("No Transactions to Show");
      }
      return transactions;
   }


   /*-----------------------------------------   View All Transaction  ----------------------------------------------*/
   @Override
   public List<Transaction> viewAllTransaction() throws TransactionException {

      List<Transaction> transactions = transactionRepository.findAll();

      if(transactions.isEmpty()){
         throw new TransactionException("No Transactions to Show");
      }
      return transactions;
   }


}