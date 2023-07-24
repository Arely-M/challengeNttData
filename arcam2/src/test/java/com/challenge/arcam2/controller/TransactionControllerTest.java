package com.challenge.arcam2.controller;

import com.challenge.arcam2.service.ITransactionService;
import com.challenge.arcam2.util.MockMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionControllerTest {

    @InjectMocks
    TransactionController transactionController;

    @Mock
    private ITransactionService iTransactionService;

    @Test
    void listAll() {
        Mockito.when(iTransactionService.listAll()).thenReturn(MockMethod.listTransactionResponse());
        Assertions.assertNotNull(transactionController.listAll());
    }

    @Test
    void listById() {
        Mockito.when(iTransactionService.listById(Mockito.anyInt())).thenReturn(MockMethod.transactionResponse());
        Assertions.assertNotNull(transactionController.listById(Mockito.anyInt()));
    }

    @Test
    void create() {
        Mockito.when(iTransactionService.create(MockMethod.transactionRequest())).thenReturn(MockMethod.transactionResponse());
        Assertions.assertNotNull(transactionController.create(MockMethod.transactionRequest()));
    }

    @Test
    void update() {
        Mockito.when(iTransactionService.update(Mockito.anyInt(), Mockito.any())).thenReturn(MockMethod.transactionResponse());
        Assertions.assertNotNull(transactionController.update(1, MockMethod.transactionRequest()));
    }

    @Test
    void deleteById() {
        iTransactionService.deleteById(Mockito.anyInt());
        Mockito.when(iTransactionService.listById(Mockito.anyInt())).thenReturn(null);
    }
}