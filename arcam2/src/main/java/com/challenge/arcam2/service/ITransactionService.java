package com.challenge.arcam2.service;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITransactionService {
    List<dtoTransactionResponse> listAll();
    dtoTransactionResponse listById(int idAccount);
    dtoTransactionResponse create(dtoTransactionRequest account);
    dtoTransactionResponse update(int idAccount, dtoTransactionRequest account);
    void deleteById(int idAccount);
}
