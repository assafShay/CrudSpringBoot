package com.harel.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class PersonDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("idNum")
    private String idNum;

    @JsonProperty("insertDate")
    private String insertDate;

    public PersonDto(UUID id, String firstName, String lastName, String phone, String idNum, String insertDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.idNum = idNum;
        this.insertDate = insertDate;
    }

    public PersonDto(){};

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
}
