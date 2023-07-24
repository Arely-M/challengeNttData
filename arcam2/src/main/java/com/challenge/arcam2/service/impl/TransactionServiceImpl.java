package com.challenge.arcam2.service.impl;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.mapper.ITransactionMapper;
import com.challenge.arcam2.model.entity.Account;
import com.challenge.arcam2.model.entity.Transaction;
import com.challenge.arcam2.repository.ITransactionRepository;
import com.challenge.arcam2.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    private final ITransactionRepository iTransactionRepository;

    @Override
    public List<dtoTransactionResponse> listAll() {

        return ITransactionMapper.INSTANCE.listTransactionToList(iTransactionRepository.findAll());
    }

    @Override
    public dtoTransactionResponse listById(int idTransaction) {
        dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(iTransactionRepository.findById(idTransaction).get());
        return transactionResponse;
    }

    @Override
    public dtoTransactionResponse create(dtoTransactionRequest transactionRequest) {
        Transaction transaction = iTransactionRepository.save(ITransactionMapper.INSTANCE.dtoTransactionRequestToTransaction(transactionRequest));
        dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(transaction);
        return transactionResponse;
    }

    @Override
    public dtoTransactionResponse update(int idTransaction, dtoTransactionRequest transactionRequest) {
        Account account = iTransactionRepository.getbyAccount(transactionRequest.getAccountId());

        Transaction transaction = new Transaction();

        if(transactionRequest.getTransactionType().equals("Deposito")){
            double value = account.getInitialBalance() + transactionRequest.getTransactionValue();

           // double value = transactionRequest.getTransactionBalance() + transactionRequest.getTransactionValue();
            //account.setInitialBalance(value);
            transaction.setTransactionBalance(value);
            transactionRequest.setTransactionBalance(value);
            account.setInitialBalance(value);
        } else if (transactionRequest.getTransactionType().equals("Retiro")) {
            if(transactionRequest.getTransactionBalance()==0){
                System.out.println("Saldo no disponible");
            } else if (transactionRequest.getTransactionBalance()>=transaction.getTransactionValue()) {
                double value = account.getInitialBalance() - transactionRequest.getTransactionValue();
                //double value = transactionRequest.getTransactionBalance() - transactionRequest.getTransactionValue();
                transaction.setTransactionBalance(value);
                transactionRequest.setTransactionBalance(value);
                account.setInitialBalance(value);
            }
        }
            transaction.setTransactionDate(transactionRequest.getTransactionDate());
            transaction.setTransactionType(transactionRequest.getTransactionType());
            transaction.setTransactionValue(transactionRequest.getTransactionValue());
            transaction.setAccountId(transactionRequest.getAccountId());

            dtoTransactionResponse transactionResponse = ITransactionMapper.INSTANCE.transactionTodtoTransactionResponse(iTransactionRepository.save(transaction));
        return transactionResponse;
    }

    @Override
    public void deleteById(int idTransaction) {
        iTransactionRepository.deleteById(idTransaction);
    }

}
