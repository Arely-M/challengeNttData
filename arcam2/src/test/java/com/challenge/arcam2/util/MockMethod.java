package com.challenge.arcam2.util;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.model.entity.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockMethod {

    public static List<Transaction> listTransaction(){
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction());
        return listTransaction;
    }

    public static Transaction transaction(){
        Transaction transaction = new Transaction();
        transaction.setIdTransaction(1);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionType("Ahorro");
        transaction.setTransactionValue(50.0);
        transaction.setTransactionBalance(100.0);
        transaction.setAccountId(1);
        return transaction;
    }

    public static dtoTransactionRequest transactionRequest(){
        dtoTransactionRequest transactionRequest = new dtoTransactionRequest();
        transactionRequest.setIdTransaction(1);
        transactionRequest.setTransactionDate(new Date());
        transactionRequest.setTransactionType("Ahorro");
        transactionRequest.setTransactionValue(50.0);
        transactionRequest.setTransactionBalance(100.0);
        transactionRequest.setAccountId(1);
        return transactionRequest;
    }

    public static List<dtoTransactionResponse> listTransactionResponse(){
        List<dtoTransactionResponse> listTransactionResponse = new ArrayList<>();
        listTransactionResponse.add(transactionResponse());
        return listTransactionResponse;
    }

    public static dtoTransactionResponse transactionResponse(){
        dtoTransactionResponse transactionResponse = new dtoTransactionResponse();
        transactionResponse.setIdTransaction(1);
        transactionResponse.setTransactionDate(new Date());
        transactionResponse.setTransactionType("Ahorro");
        transactionResponse.setTransactionValue(50.0);
        transactionResponse.setTransactionBalance(100.0);
        transactionResponse.setAccountId(1);
        return transactionResponse;
    }
}
