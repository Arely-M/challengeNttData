package com.challenge.arcam.service.impl;

import com.challenge.arcam.model.entity.Client;
import com.challenge.arcam.model.entity.Person;
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
class ClientServiceImplTest {
    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @Mock
    private IClientRepository iClientRepository;

    @Test
    void listAll() {
        Mockito.when(iClientRepository.findAll()).thenReturn(MockMethod.listClient());
        Assertions.assertNotNull(clientServiceImpl.listAll());
    }

    @Test
    void listById() {
        Mockito.when(iClientRepository.findAllById(Mockito.any())).thenReturn(MockMethod.listClient());
        Assertions.assertNotNull(clientServiceImpl.listAll());
    }

    @Test
    void create() {
        Mockito.when(iClientRepository.save(Mockito.any())).thenReturn(MockMethod.client());
        Assertions.assertNotNull(clientServiceImpl.create(MockMethod.clientRequest()));
    }

    @Test
    void update() {
        iClientRepository.save(Mockito.any(Client.class));
        Mockito.when(iClientRepository.save(Mockito.any())).thenReturn(MockMethod.client());
        Assertions.assertNotNull(clientServiceImpl.update(1, MockMethod.clientRequest()));
    }

    @Test
    void deleteById() {
        iClientRepository.deleteById(Mockito.anyInt());
        Mockito.when(iClientRepository.findById(Mockito.anyInt())).thenReturn(null);
    }
}