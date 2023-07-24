package com.challenge.arcam.service;

import com.challenge.arcam.dto.dtoAccountRequest;
import com.challenge.arcam.dto.dtoAccountResponse;

import java.util.List;

public interface IAccountService {
    List<dtoAccountResponse> listAll();
    dtoAccountResponse listById(int idAccount);
    dtoAccountResponse create(dtoAccountRequest account);
    dtoAccountResponse update(int idAccount, dtoAccountRequest account);
    void deleteById(int idAccount);
}
