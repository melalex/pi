package com.room414.hospital.domain.entities;

import com.room414.hospital.domain.Identifiable;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Duty implements Identifiable<Long>, Serializable {
    private static final long serialVersionUID = -1768900579525126303L;

    private Long id;
    private Doctor doctor;
    private Date date;
}
