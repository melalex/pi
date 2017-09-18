package com.room414.hospital.dao.mapping.impl;

import com.room414.hospital.domain.entities.Patient;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class PatientMapper extends AbstractRowMapper<Patient> {
    private static final String ID_COLUMN = "patient.id";
    private static final String FIRST_NAME_COLUMN = "patient.first_name";
    private static final String LAST_NAME_COLUMN = "patient.last_name";
    private static final String DESCRIPTION_COLUMN = "patient.description";

    private DoctorMapper doctorMapper;

    @Override
    protected Patient mapEntity(ResultSet resultSet) throws SQLException {
        Patient patient = new Patient();

        patient.setId(resultSet.getLong(ID_COLUMN));
        patient.setFirstName(resultSet.getString(FIRST_NAME_COLUMN));
        patient.setLastName(resultSet.getString(LAST_NAME_COLUMN));
        patient.setDescription(resultSet.getString(DESCRIPTION_COLUMN));
        patient.setDoctor(doctorMapper.map(resultSet));

        return patient;
    }

    @Override
    public Class<Patient> support() {
        return Patient.class;
    }
}
