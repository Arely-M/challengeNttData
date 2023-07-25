package com.challenge.arcam2.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Report {

    private Date date;
    private int clientId;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean accountStatus;
    private Double transaction;
    private Double availableBalance;
}
