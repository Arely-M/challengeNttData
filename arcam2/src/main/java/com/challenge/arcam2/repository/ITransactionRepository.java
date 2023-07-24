package com.challenge.arcam2.repository;

import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value="SELECT t FROM Account t WHERE t.idAccount=?1")
    Account getbyAccount(Integer id);
}
