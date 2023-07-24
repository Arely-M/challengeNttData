package com.challenge.arcam.util;

import com.challenge.arcam.dto.dtoAccountRequest;
import com.challenge.arcam.dto.dtoAccountResponse;
import com.challenge.arcam.dto.dtoClientRequest;
import com.challenge.arcam.dto.dtoClientResponse;
import com.challenge.arcam.model.entity.Account;
import com.challenge.arcam.model.entity.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockMethod {
    public static List<Client> listClient(){
        List<Client> listClient = new ArrayList<>();
        listClient.add(client());
        return listClient;
    }

    public static Client client(){
        Client client = new Client();
        client.setIdClient(1);
        client.setNamePerson("Denise");
        client.setAgePerson(24);
        client.setDocumentPerson("1205361007");
        client.setAddressPerson("Urdesa Sur");
        client.setPhonePerson("0962715777");
        client.setClientPassword("admin");
        client.setClientStatus(true);
        return client;
    }

    public static dtoClientRequest clientRequest(){
        dtoClientRequest clientRequest = new dtoClientRequest();
        clientRequest.setIdClient(1);
        clientRequest.setNamePerson("Denise");
        clientRequest.setTypePerson("Femenino");
        clientRequest.setAgePerson(24);
        clientRequest.setDocumentPerson("1205361007");
        clientRequest.setAddressPerson("Urdesa Sur");
        clientRequest.setPhonePerson("0962715777");
        clientRequest.setClientPassword("admin");
        clientRequest.setClientStatus(true);
        return clientRequest;
    }

    public static List<dtoClientResponse> listClientResponse(){
        List<dtoClientResponse> listClientResponse = new ArrayList<>();
        listClientResponse.add(clientResponse());
        return listClientResponse;
    }

    public static dtoClientResponse clientResponse(){
        dtoClientResponse clientResponse = new dtoClientResponse();
        clientResponse.setIdClient(1);
        clientResponse.setNamePerson("Denise");
        clientResponse.setTypePerson("Femenino");
        clientResponse.setAgePerson(24);
        clientResponse.setDocumentPerson("1205361007");
        clientResponse.setAddressPerson("Urdesa Sur");
        clientResponse.setPhonePerson("0962715777");
        clientResponse.setClientPassword("admin");
        clientResponse.setClientStatus(true);
        return clientResponse;
    }

    public static List<dtoClientRequest> listClientRequest(){
        List<dtoClientRequest> listClientRequest = new ArrayList<>();
        listClientRequest.add(clientRequest());
        return listClientRequest;
    }

    public static List<Account> listAccount(){
        List<Account> listAccount = new ArrayList<>();
        listAccount.add(account());
        return listAccount;
    }

    public static Account account(){
        Account account = new Account();
        account.setIdAccount(1);
        account.setAccountNumber("00000001");
        account.setAccountType("Ahorro");
        account.setInitialBalance(50.0);
        account.setAccountStatus(true);
        return account;
    }

    public static dtoAccountRequest accountRequest(){
        dtoAccountRequest accountRequest = new dtoAccountRequest();
        accountRequest.setIdAccount(1);
        accountRequest.setAccountNumber("00000001");
        accountRequest.setAccountType("Ahorro");
        accountRequest.setInitialBalance(50.0);
        accountRequest.setAccountStatus(true);
        accountRequest.setClientId(1);
        return accountRequest;
    }

    public static List<dtoAccountResponse> listAccountResponse(){
        List<dtoAccountResponse> listAccountResponse = new ArrayList<>();
        listAccountResponse.add(accountResponse());
        return listAccountResponse;
    }

    public static dtoAccountResponse accountResponse(){
        dtoAccountResponse accountResponse = new dtoAccountResponse();
        accountResponse.setIdAccount(1);
        accountResponse.setAccountNumber("00000001");
        accountResponse.setAccountType("Ahorro");
        accountResponse.setInitialBalance(50.0);
        accountResponse.setAccountStatus(true);
        accountResponse.setClientId(1);
        return accountResponse;
    }
}
