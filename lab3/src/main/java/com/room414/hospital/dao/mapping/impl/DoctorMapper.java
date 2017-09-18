package com.room414.hospital.dao.mapping.impl;

import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.entities.Secession;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class DoctorMapper extends AbstractRowMapper<Doctor> {
    private static final String FIRST_NAME_COLUMN = "doctor.first_name";
    private static final String LAST_NAME_COLUMN = "doctor.last_name";
    private static final String SECESSION_COLUMN = "doctor.secession_name";

    private ApplicationUserMapper userMapper;

    @Override
    protected Doctor mapEntity(ResultSet resultSet) throws SQLException {
        Doctor doctor = new Doctor();

        doctor.setApplicationUser(userMapper.map(resultSet));
        doctor.setFirstName(resultSet.getString(FIRST_NAME_COLUMN));
        doctor.setLastName(resultSet.getString(LAST_NAME_COLUMN));
        doctor.setSecession(Secession.of(resultSet.getString(SECESSION_COLUMN)));

        return doctor;
    }

    @Override
    public Class<Doctor> support() {
        return Doctor.class;
    }
}
