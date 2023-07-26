package com.challenge.arcam2.service.impl;

import com.challenge.arcam2.model.entity.Transaction;
import com.challenge.arcam2.repository.IAccountRepository;
import com.challenge.arcam2.repository.ITransactionRepository;
import com.challenge.arcam2.util.MockMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionServiceImplTest {

    @InjectMocks
    TransactionServiceImpl transactionServiceImpl;

    @Mock
    private ITransactionRepository iTransactionRepository;
    @Mock
    private IAccountRepository iAccountRepository;

    @Test
    void listAll() {
        Mockito.when(iTransactionRepository.findAll()).thenReturn(MockMethod.listTransaction());
        Assertions.assertNotNull(transactionServiceImpl.listAll());
    }

    @Test
    void listById() {
        Mockito.when(iTransactionRepository.findAllById(Mockito.any())).thenReturn(MockMethod.listTransaction());
        Assertions.assertNotNull(transactionServiceImpl.listAll());
    }

    /*@Test
    void create() {
        Mockito.when(iAccountRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(MockMethod.account()));
        iTransactionRepository.save(Mockito.any(Transaction.class));
        Mockito.when(iAccountRepository.save(Mockito.any())).thenReturn(MockMethod.account());
        Mockito.when(iTransactionRepository.getByIdAccount(Mockito.anyInt())).thenReturn(MockMethod.account())
        Assertions.assertNotNull(transactionServiceImpl.create(MockMethod.transactionRequest()));

    }*/

    /*@Test
    void update() {
        Mockito.when(iTransactionRepository.getByIdTransaction(Mockito.anyInt())).thenReturn(MockMethod.transaction());
        Mockito.when(iAccountRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(MockMethod.account()));
        Mockito.when(iTransactionRepository.save(Mockito.any())).thenReturn(MockMethod.transaction());
        Mockito.when(iTransactionRepository.getByIdAccount(Mockito.anyInt())).thenReturn(MockMethod.account());
        iTransactionRepository.save(Mockito.any(Transaction.class));
        Assertions.assertNotNull(transactionServiceImpl.update(1, MockMethod.transactionRequest()));
    }*/

    @Test
    void deleteById() {
        iTransactionRepository.deleteById(Mockito.anyInt());
        Mockito.when(iTransactionRepository.findById(Mockito.anyInt())).thenReturn(null);

    }
}