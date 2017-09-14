package com.room414.hospital.domain;

import lombok.Data;

@Data
public class Patient {
    private User user;
    private String firstName;
    private String lastName;
    private String description;
}
