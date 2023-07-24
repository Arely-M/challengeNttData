package com.challenge.arcam.mapper;

import com.challenge.arcam.dto.dtoClientRequest;
import com.challenge.arcam.dto.dtoClientResponse;
import com.challenge.arcam.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClientMapper {

    IClientMapper INSTANCE = Mappers.getMapper(IClientMapper.class);

    Client dtoClientRequestToClient(dtoClientRequest clientRequest);
    dtoClientResponse ClientTodtoClientResponse(Client client);
    List<dtoClientResponse> listClientToList(List<Client> client);
}
