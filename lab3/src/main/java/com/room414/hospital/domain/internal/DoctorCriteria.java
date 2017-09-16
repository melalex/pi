package com.room414.hospital.domain.internal;

import com.room414.hospital.domain.entities.Secession;
import lombok.Data;

import java.sql.Date;

@Data
public class DoctorCriteria {
    private Secession secession;
    private Date dutyDate;
}
