package com.challenge.arcam.controller;

import com.challenge.arcam.service.IClientService;
import com.challenge.arcam.util.MockMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientControllerTest {

    @InjectMocks
    ClientController clientController;

    @Mock
    private IClientService iClientService;

    @Test
    void listAll() {
        Mockito.when(iClientService.listAll()).thenReturn(MockMethod.listClientResponse());
        Assertions.assertNotNull(clientController.listAll());
    }

    @Test
    void listById() {
        Mockito.when(iClientService.listById(Mockito.anyInt())).thenReturn(MockMethod.clientResponse());
        Assertions.assertNotNull(clientController.listById(Mockito.anyInt()));
    }

    @Test
    void create() {
        Mockito.when(iClientService.create(MockMethod.clientRequest())).thenReturn(MockMethod.clientResponse());
        Assertions.assertNotNull(clientController.create(MockMethod.clientRequest()));
    }

    @Test
    void update() {
        Mockito.when(iClientService.update(Mockito.anyInt(), Mockito.any())).thenReturn(MockMethod.clientResponse());
        Assertions.assertNotNull(clientController.update(1, MockMethod.clientRequest()));
    }

    @Test
    void deleteById() {
        iClientService.deleteById(Mockito.anyInt());
        Mockito.when(iClientService.listById(Mockito.anyInt())).thenReturn(null);
    }
}