package com.mywallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywallet.model.Beneficiary;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, String>{

	@Query(value = "from Beneficiary b INNER JOIN b.wallet w where w.walletId=?1 AND b.beneficiaryName =?2")
	public Beneficiary findByNameWallet(Integer walletId,String name);

	@Query(value = "from Beneficiary b INNER JOIN b.wallet w where w.walletId=?1 AND b.beneficiaryMobile =?2")
	public Beneficiary findByMobWallet(Integer walletId,String name);

	@Query(value = "from Beneficiary b INNER JOIN b.wallet w where w.walletId=?1")
	public List<Beneficiary> findByWallet(Integer walletId);

}