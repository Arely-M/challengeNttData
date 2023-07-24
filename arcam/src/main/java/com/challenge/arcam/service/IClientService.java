package com.challenge.arcam.service;


import com.challenge.arcam.dto.dtoClientRequest;
import com.challenge.arcam.dto.dtoClientResponse;

import java.util.List;

public interface IClientService {

    List<dtoClientResponse> listAll();
    dtoClientResponse listById(int idClient);
    dtoClientResponse create(dtoClientRequest client);
    dtoClientResponse update(int idClient, dtoClientRequest client);
    void deleteById(int idClient);
}
