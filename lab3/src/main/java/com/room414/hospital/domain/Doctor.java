package com.room414.hospital.domain;

import lombok.Data;

@Data
public class Doctor {
    private User user;
    private String firstName;
    private String lastName;
    private Secession secession;

    public enum Secession {

    }
}
