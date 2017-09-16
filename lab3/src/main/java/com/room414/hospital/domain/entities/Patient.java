package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;

@Data
public class Patient implements Identifiable<Long> {
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private Doctor doctor;
}
