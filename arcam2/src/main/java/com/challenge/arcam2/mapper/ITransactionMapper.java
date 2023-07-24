package com.challenge.arcam2.mapper;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.model.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {

    ITransactionMapper INSTANCE = Mappers.getMapper(ITransactionMapper.class);

    Transaction dtoTransactionRequestToTransaction(dtoTransactionRequest dtoTransactionRequest);
    dtoTransactionResponse transactionTodtoTransactionResponse(Transaction transaction);
    List<dtoTransactionResponse> listTransactionToList(List<Transaction> transaction);
}
