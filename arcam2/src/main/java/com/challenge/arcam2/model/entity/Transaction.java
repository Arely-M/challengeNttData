package com.challenge.arcam2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_transaction")
    private int idTransaction;

    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "transaction_value")
    private Double transactionValue;
    @Column(name = "transaction_balance")
    private Double transactionBalance;
    @Column(name = "account_id")
    private int accountId;
}
