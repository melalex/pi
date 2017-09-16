package com.room414.hospital.dao.impl;

import com.room414.hospital.dao.DoctorDao;
import com.room414.hospital.dao.ApplicationUserDao;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.entities.Secession;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class DoctorDaoImpl implements DoctorDao {
    // @formatter:off

    private static final String CREATE_QUERY =
            "INSERT INTO doctor (application_user, first_name, last_name, secession) " +
            "VALUES (?, ?, ?, ?)";

    private static final String UPDATE_QUERY =
            "UPDATE doctor " +
            "SET first_name = ?, last_name = ?, secession = ? " +
            "WHERE application_user = ?";

    private static final String FIND_ONE_QUERY =
            "SELECT * " +
            "FROM doctor " +
            "WHERE application_user = ?";

    private static final String FIND_ALL_QUERY =
            "SELECT * " +
            "FROM doctor " +
            "LIMIT ? OFFSET ?";

    private static final String FIND_BY_DUTY_QUERY =
            "SELECT * " +
            "FROM doctor " +
            "   LEFT JOIN duty " +
            "       ON doctor.application_user = duty.doctor " +
            "WHERE duty.date = ? LIMIT ? OFFSET ?";

    private static final String FIND_BY_SECESSION_QUERY =
            "SELECT * " +
            "FROM doctor " +
            "WHERE secession = ? LIMIT ? OFFSET ?";

    // @formatter:on

    private QueryTemplate queryTemplate;
    private ApplicationUserDao applicationUserDao;

    @Override
    public void create(Doctor doctor) {
        applicationUserDao.create(doctor.getApplicationUser());

        queryTemplate.update()
                .withQuery(CREATE_QUERY)
                .withParam(doctor.getApplicationUser())
                .withParam(doctor.getFirstName())
                .withParam(doctor.getLastName())
                .withParam(doctor.getSecession())
                .execute();
    }

    @Override
    public void update(Doctor doctor) {
        queryTemplate.update()
                .withQuery(UPDATE_QUERY)
                .withParam(doctor.getFirstName())
                .withParam(doctor.getLastName())
                .withParam(doctor.getSecession())
                .withParam(doctor.getApplicationUser())
                .execute();
    }

    @Override
    public Optional<Doctor> findOne(String username) {
        return queryTemplate.selectOne(Doctor.class)
                .withQuery(FIND_ONE_QUERY)
                .withParam(username)
                .execute();
    }

    @Override
    public List<Doctor> findAll(Pageable pageable) {
        return queryTemplate.selectMany(Doctor.class)
                .withQuery(FIND_ALL_QUERY)
                .withParam(pageable)
                .execute();
    }

    @Override
    public List<Doctor> findByDuty(Date date, Pageable pageable) {
        return queryTemplate.selectMany(Doctor.class)
                .withQuery(FIND_BY_DUTY_QUERY)
                .withParam(date)
                .withParam(pageable)
                .execute();
    }

    @Override
    public List<Doctor> findBySecession(Secession secession) {
        return queryTemplate.selectMany(Doctor.class)
                .withQuery(FIND_BY_SECESSION_QUERY)
                .withParam(secession)
                .execute();
    }
}
