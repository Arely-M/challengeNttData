package com.challenge.arcam2.service.impl;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.error.DefaultError;
import com.challenge.arcam2.error.ExceptionArcam;
import com.challenge.arcam2.mapper.ITransactionMapper;
import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Report;
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

    public dtoTransactionRequest creditDebits (String action,dtoTransactionRequest transactionRequest){
        Account account = null;
        if(action.equals("create")){
            account = iTransactionRepository.getByAccount(transactionRequest.getAccountId());
        } else if (action.equals("update")) {
            account = iTransactionRepository.getByTransactionAccount(transactionRequest.getAccountId());
        }
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
        return transactionRequest;
    }

    @Override
    public dtoTransactionResponse create(dtoTransactionRequest transactionRequest) {
        dtoTransactionRequest transactionRequest1 = creditDebits("create",transactionRequest);
        Transaction transaction = iTransactionRepository.save(ITransactionMapper.INSTANCE.dtoTransactionRequestToTransaction(transactionRequest1));
        dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(transaction);
        return transactionResponse;
    }

    @Override
    public dtoTransactionResponse update(int idTransaction, dtoTransactionRequest transactionRequest) {
        dtoTransactionResponse transactionResponse = null;
        dtoTransactionRequest transactionRequest1 = creditDebits("update",transactionRequest);
        Account account = iTransactionRepository.getByTransactionAccount(transactionRequest.getAccountId());
        if(account != null){
            Transaction transaction = iTransactionRepository.findById(idTransaction).orElseGet(Transaction::new);

            transaction.setTransactionDate(transactionRequest.getTransactionDate());
            transaction.setTransactionType(transactionRequest.getTransactionType());
            transaction.setTransactionValue(transactionRequest.getTransactionValue());
            transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(iTransactionRepository.save(transaction));
            return transactionResponse;
        } else {
            return create(transactionRequest);
        }
    }

    /*@Override
    public dtoTransactionResponse update(int idTransaction, dtoTransactionRequest transactionRequest) {
        dtoTransactionResponse transactionResponse = null;
        Account account = iTransactionRepository.getByTransactionAccount(transactionRequest.getAccountId());
        if(account != null){
            Transaction transaction = iTransactionRepository.findById(idTransaction).orElseGet(Transaction::new);
            double initialBalance = account.getInitialBalance();
            double transactionValue = transactionRequest.getTransactionValue();
            double newBalance = 0;
            if (transactionRequest.getTransactionType().equals("Deposito")) {
                newBalance = initialBalance + transactionValue;
                account.setInitialBalance(newBalance);
                iAccountRepository.save(account);
            } else if (transactionRequest.getTransactionType().equals("Retiro")) {
                if (initialBalance - transactionValue >= 0) {
                    newBalance = initialBalance - transactionValue;
                    account.setInitialBalance(newBalance);
                    iAccountRepository.save(account);
                } else {
                    throw new ExceptionArcam(DefaultError.error002);
                }
            }
            transaction.setTransactionDate(transactionRequest.getTransactionDate());
            transaction.setTransactionType(transactionRequest.getTransactionType());
            transaction.setTransactionValue(transactionRequest.getTransactionValue());
            transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(iTransactionRepository.save(transaction));
            return transactionResponse;
        } else {
            return create(transactionRequest);
        }
    }*/

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
