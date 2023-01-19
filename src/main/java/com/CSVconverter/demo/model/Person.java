package com.CSVconverter.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("Name") String name, @JsonProperty("Email") String email, @JsonProperty("Phone Number") String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
