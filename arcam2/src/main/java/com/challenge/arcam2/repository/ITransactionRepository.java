package com.challenge.arcam2.repository;

import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value="SELECT t FROM Transaction t WHERE t.idTransaction=?1")
    Transaction getByIdTransaction(int idTransaction);

    @Query(value="SELECT a FROM Account a WHERE a.idAccount=?1")
    Account getByIdAccount(int idAccount);

    @Query(value = "SELECT a FROM Transaction t " +
            "JOIN Account a on t.id = a.idAccount " +
            "WHERE t.idTransaction=?1")
    Account getByTransactionAccount(int idAccount);

    /*@Query(value="SELECT c FROM Account a JOIN  Client c  on a.clientId  = c.idClient  WHERE a.idAccount =?1")
    Account getClientById(int id);

    @Query(value="SELECT c FROM Account a JOIN  Client c  on a.clientId  = c.idClient  WHERE a.idAccount =?1")
    List<Account> accountByClient(Client client);

    @Query(value="SELECT c FROM Account a JOIN  C" +
            "lient c  on a.clientId  = c.idClient  WHERE a.idAccount =?1")
    List<Transaction> transactionByAccountAndDate(Account account, Date startDate, Date endDate);
*/
}
