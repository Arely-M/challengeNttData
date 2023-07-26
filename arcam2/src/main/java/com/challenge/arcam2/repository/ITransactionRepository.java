package com.challenge.arcam2.repository;

import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Client;
import com.challenge.arcam2.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value="SELECT t FROM Transaction t WHERE t.idTransaction=?1")
    Transaction getByIdTransaction(int idTransaction);

    @Query(value="SELECT a FROM Account a WHERE a.idAccount=?1")
    Account getByIdAccount(int idAccount);
    @Query(value="SELECT c FROM Account c WHERE c.clientId=?1")
    Account getClientById(int idClient);
    @Query(value="SELECT c FROM Client c WHERE c.idClient=?1")
    Client getByIdClient(int idClient);
    @Query(value="SELECT t FROM Transaction t WHERE t.accountId=?1 AND t.transactionDate BETWEEN ?2 AND ?3")
    List<Transaction> transactionByAccountAndDate(Integer idAccount, Date startDate, Date endDate);
}
