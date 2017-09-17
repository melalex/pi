package com.room414.hospital.domain.internal;

import com.room414.hospital.domain.entities.Secession;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class DoctorCriteria implements Serializable {
    private static final long serialVersionUID = 908219372229617574L;

    private Secession secession;
    private Date dutyDate;
}
