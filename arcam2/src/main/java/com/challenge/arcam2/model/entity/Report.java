package com.challenge.arcam2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Report {

    private Date date;
    private String clientName;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean accountStatus;
    private Double transaction;
    private Double currentBalance;
}
