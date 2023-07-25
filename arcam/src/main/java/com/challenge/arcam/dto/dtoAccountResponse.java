package com.challenge.arcam.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class dtoAccountResponse implements Serializable {

    private int idAccount;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Double currentBalance;
    private Boolean accountStatus;
    private int clientId;
}
