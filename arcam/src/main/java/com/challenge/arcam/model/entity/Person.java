package com.challenge.arcam.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class Person {

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
