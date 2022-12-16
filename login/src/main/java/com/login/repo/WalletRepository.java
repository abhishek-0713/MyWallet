package com.login.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
		
	@Query("from Wallet w INNER JOIN w.customer c where c.customerId=?1")
	public Wallet showWalletDetails(Integer id); 
	
}
