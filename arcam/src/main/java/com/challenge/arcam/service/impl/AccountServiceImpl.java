package com.challenge.arcam.service.impl;

import com.challenge.arcam.dto.dtoAccountRequest;
import com.challenge.arcam.dto.dtoAccountResponse;
import com.challenge.arcam.error.DefaultError;
import com.challenge.arcam.error.ExceptionArcam;
import com.challenge.arcam.mapper.IAccountMapper;
import com.challenge.arcam.model.entity.Account;
import com.challenge.arcam.repository.IAccountRepository;
import com.challenge.arcam.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final IAccountRepository iAccountRepository;

    @Override
    public List<dtoAccountResponse> listAll() {

        return IAccountMapper.INSTANCE.listAccountToList(iAccountRepository.findAll());
    }

    @Override
    public dtoAccountResponse listById(int idAccount) {
        dtoAccountResponse accountResponse = IAccountMapper.INSTANCE.AccountTodtoAccountResponse(iAccountRepository.findById(idAccount).get());
        return accountResponse;
    }

    @Override
    public dtoAccountResponse create(dtoAccountRequest accountRequest) {
        Account account = IAccountMapper.INSTANCE.dtoAccountRequestToAccount(accountRequest);
        account.setCurrentBalance(accountRequest.getInitialBalance());
        iAccountRepository.save(account);
        dtoAccountResponse accountResponse = IAccountMapper.INSTANCE.AccountTodtoAccountResponse(account);
        return accountResponse;
    }

    @Override
    public dtoAccountResponse update(int idAccount, dtoAccountRequest accountRequest) {
        Account account = iAccountRepository.findById(idAccount).orElse(null);
        if(Objects.isNull(account))
            throw new ExceptionArcam(DefaultError.error001);
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setAccountType(accountRequest.getAccountType());
        account.setInitialBalance(accountRequest.getInitialBalance());
        account.setCurrentBalance(accountRequest.getCurrentBalance());
        account.setAccountStatus(accountRequest.getAccountStatus());
        account.setClientId(accountRequest.getClientId());
        dtoAccountResponse accountResponse = IAccountMapper.INSTANCE.AccountTodtoAccountResponse(iAccountRepository.save(account));
        return accountResponse;
    }

    @Override
    public void deleteById(int idAccount) {
        iAccountRepository.deleteById(idAccount);
    }
}
