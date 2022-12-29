package com.mywallet.repository;

import com.mywallet.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentRepo extends JpaRepository<BillPayment, Integer> {

}