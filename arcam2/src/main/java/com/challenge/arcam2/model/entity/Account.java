package com.challenge.arcam2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Account {
    @Id
    @Column(name = "id_account")
    private int idAccount;

    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "initial_balance")
    private Double initialBalance;
    @Column(name = "current_balance")
    private Double currentBalance;
    @Column(name = "account_status")
    private Boolean accountStatus;
    @Column(name = "client_id")
    private int clientId;
}
