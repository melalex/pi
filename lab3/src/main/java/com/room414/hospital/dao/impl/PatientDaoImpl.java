package com.room414.hospital.dao.impl;

import com.room414.hospital.dao.PatientDao;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Patient;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PatientDaoImpl implements PatientDao {
    // @formatter:off

    private static final String CREATE_QUERY =
            "INSERT INTO patient (first_name, last_name, description, doctor) " +
            "VALUES (?, ?, ?, ?)";

    private static final String UPDATE_QUERY =
            "UPDATE patient " +
            "SET first_name = ?, last_name = ?, description = ?, doctor = ? " +
            "WHERE id = ?";

    private static final String FIND_ONE_QUERY =
            "SELECT * " +
            "FROM patient " +
            "WHERE id = ?";

    private static final String FIND_ALL_QUERY =
            "SELECT * " +
            "FROM patient " +
            "LIMIT ? OFFSET ?";

    // @formatter:on

    private QueryTemplate queryTemplate;

    @Override
    public void create(Patient patient) {
        queryTemplate.update()
                .withQuery(CREATE_QUERY)
                .withParam(patient.getFirstName())
                .withParam(patient.getLastName())
                .withParam(patient.getDescription())
                .withParam(patient.getDoctor())
                .execute();
    }

    @Override
    public void update(Patient patient) {
        queryTemplate.update()
                .withQuery(UPDATE_QUERY)
                .withParam(patient.getFirstName())
                .withParam(patient.getLastName())
                .withParam(patient.getDescription())
                .withParam(patient.getDoctor())
                .withParam(patient.getId())
                .execute();
    }

    @Override
    public Optional<Patient> findOne(long id) {
        return queryTemplate.selectOne(Patient.class)
                .withQuery(FIND_ONE_QUERY)
                .withParam(id)
                .execute();
    }

    @Override
    public List<Patient> findAll(Pageable pageable) {
        return queryTemplate.selectMany(Patient.class)
                .withQuery(FIND_ALL_QUERY)
                .withParam(pageable)
                .execute();
    }
}
