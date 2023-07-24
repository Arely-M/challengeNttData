package com.challenge.arcam.controller;

import com.challenge.arcam.service.IAccountService;
import com.challenge.arcam.util.MockMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountControllerTest {

    @InjectMocks
    AccountController accountController;

    @Mock
    private IAccountService iAccountService;

    @Test
    void listAll() {
        Mockito.when(iAccountService.listAll()).thenReturn(MockMethod.listAccountResponse());
        Assertions.assertNotNull(accountController.listAll());
    }

    @Test
    void listById() {
        Mockito.when(iAccountService.listById(Mockito.anyInt())).thenReturn(MockMethod.accountResponse());
        Assertions.assertNotNull(accountController.listById(Mockito.anyInt()));
    }

    @Test
    void create() {
        Mockito.when(iAccountService.create(MockMethod.accountRequest())).thenReturn(MockMethod.accountResponse());
        Assertions.assertNotNull(accountController.create(MockMethod.accountRequest()));
    }

    @Test
    void update() {
        Mockito.when(iAccountService.update(Mockito.anyInt(), Mockito.any())).thenReturn(MockMethod.accountResponse());
        Assertions.assertNotNull(accountController.update(1, MockMethod.accountRequest()));
    }

    @Test
    void deleteById() {
        iAccountService.deleteById(Mockito.anyInt());
        Mockito.when(iAccountService.listById(Mockito.anyInt())).thenReturn(null);
    }
}