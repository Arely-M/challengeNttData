package com.challenge.arcam.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class dtoClientResponse implements Serializable {

    private int idClient;
    private String namePerson;
    private String typePerson;
    private Integer agePerson;
    private String documentPerson;
    private String addressPerson;
    private String phonePerson;
    private String clientPassword;
    private Boolean clientStatus;
}
