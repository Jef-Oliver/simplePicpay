package com.picpaysimplificado.simplepicpay.repositories;

import com.picpaysimplificado.simplepicpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
