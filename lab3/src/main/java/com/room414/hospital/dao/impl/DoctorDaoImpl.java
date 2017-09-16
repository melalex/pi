package com.room414.hospital.dao.impl;

import com.room414.hospital.dao.DoctorDao;
import com.room414.hospital.dao.ApplicationUserDao;
import com.room414.hospital.dao.mapping.RowExtractor;
import com.room414.hospital.dao.mapping.impl.CountExtractor;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.entities.Secession;
import com.room414.hospital.domain.internal.DoctorCriteria;
import lombok.AllArgsConstructor;
import org.intellij.lang.annotations.Language;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class DoctorDaoImpl implements DoctorDao {
    // @formatter:off

    @Language("MySQL")
    private static final String CREATE_QUERY =
            "INSERT INTO doctor (application_user, first_name, last_name, secession) " +
            "VALUES (?, ?, ?, ?)";

    @Language("MySQL")
    private static final String UPDATE_QUERY =
            "UPDATE doctor " +
            "SET first_name = ?, last_name = ?, secession = ? " +
            "WHERE application_user = ?";

    @Language("MySQL")
    private static final String FIND_ONE_QUERY =
            "SELECT * " +
            "FROM doctor " +
            "WHERE application_user = ?";

    @Language("MySQL")
    private static final String FIND_BY_CRITERIA_QUERY =
            "SELECT * " +
            "FROM doctor " +
            "   LEFT JOIN duty " +
            "       ON doctor.application_user = duty.doctor " +
            "WHERE (? IS NULL OR doctor.secession = ?) " +
            "       AND (? IS NULL OR duty.date = ?) " +
            "LIMIT ? OFFSET ?";

    @Language("MySQL")
    private static final String COUNT_BY_CRITERIA_QUERY =
            "SELECT COUNT(*) " +
            "FROM doctor " +
            "   LEFT JOIN duty " +
            "       ON doctor.application_user = duty.doctor " +
            "WHERE (? IS NULL OR doctor.secession = ?) " +
            "       AND (? IS NULL OR duty.date = ?)";

    // @formatter:on

    private QueryTemplate queryTemplate;
    private ApplicationUserDao applicationUserDao;

    private final RowExtractor<Integer> countExtractor = new CountExtractor();

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
    public List<Doctor> findByCriteria(DoctorCriteria criteria, Pageable pageable) {
        return queryTemplate.selectMany(Doctor.class)
                .withQuery(FIND_BY_CRITERIA_QUERY)
                .withParam(criteria.getSecession())
                .withParam(criteria.getSecession())
                .withParam(criteria.getDutyDate())
                .withParam(criteria.getDutyDate())
                .withParam(pageable)
                .execute();
    }

    @Override
    public Integer countByCriteria(DoctorCriteria criteria) {
        return queryTemplate.aggregate(countExtractor)
                .withQuery(COUNT_BY_CRITERIA_QUERY)
                .withParam(criteria.getSecession())
                .withParam(criteria.getSecession())
                .withParam(criteria.getDutyDate())
                .withParam(criteria.getDutyDate())
                .execute();
    }
}
