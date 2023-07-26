package com.challenge.arcam2.service.impl;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.error.DefaultError;
import com.challenge.arcam2.error.ExceptionArcam;
import com.challenge.arcam2.mapper.ITransactionMapper;
import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Client;
import com.challenge.arcam2.model.entity.Report;
import com.challenge.arcam2.model.entity.Transaction;
import com.challenge.arcam2.repository.IAccountRepository;
import com.challenge.arcam2.repository.ITransactionRepository;
import com.challenge.arcam2.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.Date;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    private final ITransactionRepository iTransactionRepository;
    private final IAccountRepository iAccountRepository;


    @Override
    public List<dtoTransactionResponse> listAll() {

        return ITransactionMapper.INSTANCE.listTransactionToList(iTransactionRepository.findAll());
    }

    @Override
    public dtoTransactionResponse listById(int idTransaction) {
        dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(iTransactionRepository.findById(idTransaction).get());
        return transactionResponse;
    }

    public dtoTransactionRequest creditDebits (dtoTransactionRequest transactionRequest){
        Account account = iTransactionRepository.getByIdAccount(transactionRequest.getAccountId());
        if(Objects.isNull(account)){
            throw new ExceptionArcam(DefaultError.error001);
        }else {
            double currentBalance = account.getCurrentBalance();
            double transactionValue = transactionRequest.getTransactionValue();
            double newBalance = 0;
            if (transactionRequest.getTransactionType().equals("Deposito")) {
                newBalance = currentBalance + transactionValue;
                account.setCurrentBalance(newBalance);
                iAccountRepository.save(account);
                transactionRequest.setTransactionBalance(newBalance);
            } else if (transactionRequest.getTransactionType().equals("Retiro")) {
                if (currentBalance - transactionValue >= 0) {
                    newBalance = currentBalance - transactionValue;
                    account.setCurrentBalance(newBalance);
                    iAccountRepository.save(account);
                    transactionRequest.setTransactionBalance(newBalance);
                } else {
                    throw new ExceptionArcam(DefaultError.error002);
                }
            }
        }
        return transactionRequest;
    }

    @Override
    public dtoTransactionResponse create(dtoTransactionRequest transactionRequest) {
        dtoTransactionRequest transactionRequest1 = creditDebits(transactionRequest);
        Transaction transaction = iTransactionRepository.save(ITransactionMapper.INSTANCE.dtoTransactionRequestToTransaction(transactionRequest1));
        dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(transaction);
        return transactionResponse;
    }

    @Override
    public dtoTransactionResponse update(int idTransaction, dtoTransactionRequest transactionRequest) {
        Transaction transaction = iTransactionRepository.getByIdTransaction(idTransaction);
        if(Objects.isNull(transaction)){
            throw new ExceptionArcam(DefaultError.error003);
        } else {
            creditDebits(transactionRequest);
            transaction.setTransactionDate(transactionRequest.getTransactionDate());
            transaction.setTransactionType(transactionRequest.getTransactionType());
            transaction.setTransactionValue(transactionRequest.getTransactionValue());
            transaction.setTransactionBalance(transactionRequest.getTransactionBalance());
            transaction.setAccountId(transactionRequest.getAccountId());
        }
        dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(iTransactionRepository.save(transaction));
        return transactionResponse;
    }


    @Override
    public void deleteById(int idTransaction) {
        iTransactionRepository.deleteById(idTransaction);
    }

    public List<Report> generateReport(int clientId, Date startDate, Date endDate) {
        List<Report> reportList = new ArrayList<>();
        Account account = iTransactionRepository.getClientById(clientId);
        Client client = iTransactionRepository.getByIdClient(account.getClientId());
        List<Transaction> transactions = iTransactionRepository.transactionByAccountAndDate(account.getIdAccount(), startDate, endDate);
        for (Transaction transaction :transactions) {
            Report report = new Report();
            report.setDate(transaction.getTransactionDate());
            report.setClientName(client.getNamePerson());
            report.setAccountNumber(account.getAccountNumber());
            report.setAccountType(account.getAccountType());
            report.setInitialBalance(account.getInitialBalance());
            report.setAccountStatus(account.getAccountStatus());
            report.setTransaction(transaction.getTransactionValue());
            report.setCurrentBalance(account.getCurrentBalance());
            reportList.add(report);
        }
        return reportList;
    }
}
