package com.room414.hospital.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Duty {
    private Doctor doctor;
    private Date date;
}
