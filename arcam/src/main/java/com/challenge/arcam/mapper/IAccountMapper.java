package com.challenge.arcam.mapper;

import com.challenge.arcam.dto.dtoAccountRequest;
import com.challenge.arcam.dto.dtoAccountResponse;
import com.challenge.arcam.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAccountMapper {

    IAccountMapper INSTANCE = Mappers.getMapper(IAccountMapper.class);

    Account dtoAccountRequestToAccount(dtoAccountRequest accountRequest);
    dtoAccountResponse AccountTodtoAccountResponse(Account account);
    List<dtoAccountResponse> listAccountToList(List<Account> account);
}
