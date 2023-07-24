package com.challenge.arcam.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_account")
    private int idAccount;

    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "initial_balance")
    private Double initialBalance;
    @Column(name = "account_status")
    private Boolean accountStatus;
    @Column(name = "client_id")
    private int clientId;
}
