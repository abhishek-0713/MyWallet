package com.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywallet.model.Wallet;

public interface WalletRepo extends JpaRepository<Wallet, Integer>{

}
