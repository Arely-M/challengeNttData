package com.challenge.arcam2.service.impl;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.error.DefaultError;
import com.challenge.arcam2.error.ExceptionArcam;
import com.challenge.arcam2.mapper.ITransactionMapper;
import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Transaction;
import com.challenge.arcam2.repository.IAccountRepository;
import com.challenge.arcam2.repository.ITransactionRepository;
import com.challenge.arcam2.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /*public Report generateReport(int clientId, Date startDate, Date endDate) {
        Client client = iTransactionRepository.getClientById(clientId);
        List<Account> accounts = iTransactionRepository.accountByClient(client);
        Map<Account, Double> saldosPorCuenta = new HashMap<>();
        Map<Account, List<Transaction>> movimientosPorCuenta = new HashMap<>();

        for (Account account : accounts) {
            double saldo = account.getInitialBalance();
            List<Transaction> transactions = iTransactionRepository.transactionByAccountAndDate(account, startDate, endDate);
            for (Transaction transaction : transactions) {
                if (transaction.getTransactionType().equals("Deposito")) {
                    saldo += transaction.getTransactionValue();
                } else if (transaction.getTransactionType().equals("Retiro")) {
                    saldo -= transaction.getTransactionValue();
                }
            }
            saldosPorCuenta.put(account, saldo);
            movimientosPorCuenta.put(account, transactions);
        }
        return new Report(client, saldosPorCuenta, movimientosPorCuenta);
    }*/
}
