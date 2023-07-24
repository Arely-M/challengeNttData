package com.challenge.arcam2.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class dtoTransactionRequest implements Serializable {

    private int idTransaction;
    private Date transactionDate;
    private String transactionType;
    private Double transactionValue;
    private Double transactionBalance;
    private int accountId;
}
