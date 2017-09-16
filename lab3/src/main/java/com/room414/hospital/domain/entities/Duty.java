package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;

import java.sql.Date;

@Data
public class Duty implements Identifiable<Long> {
    private Long id;
    private Doctor doctor;
    private Date date;
}
