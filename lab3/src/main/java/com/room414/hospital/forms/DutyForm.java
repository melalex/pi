package com.room414.hospital.forms;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class DutyForm implements Serializable {
    private static final long serialVersionUID = 4994615063960259087L;

    private String doctor;
    private Date date;
}
