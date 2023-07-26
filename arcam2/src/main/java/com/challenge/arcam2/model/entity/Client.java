package com.challenge.arcam2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {
    @Id
    @Column(name = "id_client")
    private int idClient;

    @Column(name = "client_password")
    private String clientPassword;
    @Column(name = "client_status")
    private Boolean clientStatus;
    @Column(name = "name_person")
    private String namePerson;
    @Column(name = "type_person")
    private String typePerson;
    @Column(name = "age_person")
    private Integer agePerson;
    @Column(name = "document_person")
    private String documentPerson;
    @Column(name = "address_person")
    private String addressPerson;
    @Column(name = "phone_person")
    private String phonePerson;
}
