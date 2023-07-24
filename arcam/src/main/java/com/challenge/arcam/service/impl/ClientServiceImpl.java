package com.challenge.arcam.service.impl;

import com.challenge.arcam.dto.dtoClientRequest;
import com.challenge.arcam.dto.dtoClientResponse;
import com.challenge.arcam.mapper.IClientMapper;
import com.challenge.arcam.model.entity.Client;
import com.challenge.arcam.repository.IClientRepository;
import com.challenge.arcam.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository iClientRepository;

    @Override
    public List<dtoClientResponse> listAll() {

        return IClientMapper.INSTANCE.listClientToList(iClientRepository.findAll());
    }

    @Override
    public dtoClientResponse listById(int idClient) {
        dtoClientResponse clientResponse = IClientMapper.INSTANCE.ClientTodtoClientResponse(iClientRepository.findById(idClient).get());
        return clientResponse;
    }

    @Override
    public dtoClientResponse create(dtoClientRequest clientRequest) {
        Client client = iClientRepository.save(IClientMapper.INSTANCE.dtoClientRequestToClient(clientRequest));
        dtoClientResponse clientResponse = IClientMapper.INSTANCE.ClientTodtoClientResponse(client);
        return clientResponse;
    }

    @Override
    public dtoClientResponse update(int idClient, dtoClientRequest clientRequest) {
        Client client = iClientRepository.findById(idClient).orElseGet(Client::new);
        client.setNamePerson(clientRequest.getNamePerson());
        client.setTypePerson(clientRequest.getTypePerson());
        client.setAgePerson(clientRequest.getAgePerson());
        client.setDocumentPerson(clientRequest.getDocumentPerson());
        client.setAddressPerson(clientRequest.getAddressPerson());
        client.setPhonePerson(clientRequest.getPhonePerson());
        client.setClientPassword(clientRequest.getClientPassword());
        client.setClientStatus(clientRequest.getClientStatus());
        dtoClientResponse clientResponse = IClientMapper.INSTANCE.ClientTodtoClientResponse(iClientRepository.save(client));
        return clientResponse;
    }

    @Override
    public void deleteById(int idClient) {
        iClientRepository.deleteById(idClient);
    }
}
