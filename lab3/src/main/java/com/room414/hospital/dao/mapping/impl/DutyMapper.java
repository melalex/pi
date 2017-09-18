package com.room414.hospital.dao.mapping.impl;

import com.room414.hospital.domain.entities.Duty;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class DutyMapper extends AbstractRowMapper<Duty> {
    private static final String ID_COLUMN = "duty.id";
    private static final String DATE_COLUMN = "duty.date";

    private DoctorMapper doctorMapper;

    @Override
    protected Duty mapEntity(ResultSet resultSet) throws SQLException {
        Duty duty = new Duty();

        duty.setId(resultSet.getLong(ID_COLUMN));
        duty.setDoctor(doctorMapper.map(resultSet));
        duty.setDate(resultSet.getDate(DATE_COLUMN));

        return duty;
    }

    @Override
    public Class<Duty> support() {
        return Duty.class;
    }
}
