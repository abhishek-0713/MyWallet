package com.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywallet.model.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer>{

	@Query("from Wallet w INNER JOIN w.customer c where c.customerId=?1")
	public Wallet customerWalletDetailsByCId(Integer customerId);
}