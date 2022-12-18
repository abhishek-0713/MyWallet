package com.mywallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywallet.model.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer>{

	  
	 public Optional<Wallet> findByWalletId(Integer walletId);
}