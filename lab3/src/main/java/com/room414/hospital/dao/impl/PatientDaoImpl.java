package com.room414.hospital.dao.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.dao.PatientDao;
import com.room414.hospital.dao.mapping.RowExtractor;
import com.room414.hospital.dao.mapping.impl.CountExtractor;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Patient;
import org.intellij.lang.annotations.Language;

import java.util.List;
import java.util.Optional;

public class PatientDaoImpl implements PatientDao {
    // @formatter:off

    @Language("MySQL")
    private static final String CREATE_QUERY =
            "INSERT INTO patient (first_name, last_name, description, doctor) " +
            "VALUES (?, ?, ?, ?)";

    @Language("MySQL")
    private static final String UPDATE_QUERY =
            "UPDATE patient " +
            "SET first_name = ?, last_name = ?, description = ?, doctor = ? " +
            "WHERE id = ?";

    @Language("MySQL")
    private static final String FIND_ONE_QUERY =
            "SELECT * " +
            "FROM patient " +
            "   LEFT JOIN doctor " +
            "       ON patient.doctor = doctor.application_user " +
            "   LEFT JOIN application_user " +
            "       ON doctor.application_user = application_user.username " +
            "WHERE id = ?";

    @Language("MySQL")
    private static final String FIND_ALL_QUERY =
            "SELECT * " +
            "FROM patient " +
            "   LEFT JOIN doctor " +
            "       ON patient.doctor = doctor.application_user " +
            "   LEFT JOIN application_user " +
            "       ON doctor.application_user = application_user.username " +
            "LIMIT ? OFFSET ?";

    @Language("MySQL")
    private static final String COUNT_ALL_QUERY =
            "SELECT COUNT(*) " +
            "FROM patient";

    // @formatter:on

    private final QueryTemplate queryTemplate = ApplicationContext.getInstance().getQueryTemplate();

    private final RowExtractor<Integer> countExtractor = new CountExtractor();

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
    public Optional<Patient> findOne(Long id) {
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

    @Override
    public Integer countAll() {
        return queryTemplate.aggregate(countExtractor)
                .withQuery(COUNT_ALL_QUERY)
                .execute();
    }
}
