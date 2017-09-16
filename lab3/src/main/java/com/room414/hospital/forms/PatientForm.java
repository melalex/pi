package com.room414.hospital.forms;

import lombok.Data;

@Data
public class PatientForm {
    private String firstName;
    private String lastName;
    private String description;
    private String doctor;
}