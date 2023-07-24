package com.challenge.arcam.service.impl;

import com.challenge.arcam.model.entity.Account;
import com.challenge.arcam.repository.IAccountRepository;
import com.challenge.arcam.repository.IClientRepository;
import com.challenge.arcam.util.MockMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @Mock
    private IAccountRepository iAccountRepository;

    @Test
    void listAll() {
        Mockito.when(iAccountRepository.findAll()).thenReturn(MockMethod.listAccount());
        Assertions.assertNotNull(accountServiceImpl.listAll());
    }

    @Test
    void listById() {
        Mockito.when(iAccountRepository.findAllById(Mockito.any())).thenReturn(MockMethod.listAccount());
        Assertions.assertNotNull(accountServiceImpl.listAll());
    }

    @Test
    void create() {
        Mockito.when(iAccountRepository.save(Mockito.any())).thenReturn(MockMethod.account());
        Assertions.assertNotNull(accountServiceImpl.create(MockMethod.accountRequest()));
    }

    @Test
    void update() {
        iAccountRepository.save(Mockito.any(Account.class));
        Mockito.when(iAccountRepository.save(Mockito.any())).thenReturn(MockMethod.account());
        Assertions.assertNotNull(accountServiceImpl.update(1, MockMethod.accountRequest()));
    }

    @Test
    void deleteById() {
        iAccountRepository.deleteById(Mockito.anyInt());
        Mockito.when(iAccountRepository.findById(Mockito.anyInt())).thenReturn(null);
    }
}