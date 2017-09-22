package com.room414.hospital.forms;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatientForm implements Serializable {
    private static final long serialVersionUID = -3757588908421881442L;

    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private String doctor;
}