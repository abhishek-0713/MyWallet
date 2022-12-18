package com.mywallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywallet.model.BankAccount;

@Repository

public interface BankAccountRepo  extends JpaRepository<BankAccount, Integer>{
	
	@Query(value = "from BankAccount b INNER JOIN b.wallet w where w.walletId=?1")
	public List<BankAccount>  findByWalletId(Integer walletId);
	
	@Query(value = "from BankAccount b INNER JOIN b.wallet w where w.walletId=?1")
	public List<BankAccount> findAllByWalletId(Integer walletId);

}
