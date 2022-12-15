package com.mywallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywallet.model.BillPayment;

@Repository
public interface BillPaymentRepo extends JpaRepository<BillPayment, Integer>{

}
