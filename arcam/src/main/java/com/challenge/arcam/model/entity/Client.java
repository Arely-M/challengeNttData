package com.challenge.arcam.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_client")
    private int idClient;

    @Column(name = "client_password")
    private String clientPassword;
    @Column(name = "client_status")
    private Boolean clientStatus;
}
