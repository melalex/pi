package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;

import java.io.Serializable;

@Data
public class Patient implements Identifiable<Long>, Serializable {
    private static final long serialVersionUID = -8494525217878113138L;

    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private Doctor doctor;
}
