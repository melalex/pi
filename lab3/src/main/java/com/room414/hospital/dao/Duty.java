package com.room414.hospital.dao;

import lombok.Data;

import java.sql.Date;

@Data
public class Duty {
    private Doctor doctor;
    private Date date;
}
