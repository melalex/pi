package com.room414.hospital.dao.impl;

import com.room414.hospital.dao.DutyDao;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.dao.util.SqlUtil;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.ApplicationUser;
import com.room414.hospital.domain.entities.Duty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DutyDaoImpl implements DutyDao {
    // @formatter:off

    private static final String CREATE_QUERY =
            "INSERT INTO duty (doctor, date) " +
            "VALUES (?, ?)";

    private static final String FIND_BY_LAST_NAME_QUERY =
            "SELECT * " +
            "FROM duty AS d " +
            "   LEFT JOIN doctor AS doc " +
            "       ON doc.application_user = d.doctor " +
            "WHERE doc.last_name LIKE ? LIMIT ? OFFSET ?";

    // @formatter:on

    private QueryTemplate queryTemplate;


    @Override
    public void create(Duty duty) {
        queryTemplate.update()
                .withQuery(CREATE_QUERY)
                .withParam(duty.getDoctor())
                .withParam(duty.getDate())
                .execute();
    }

    @Override
    public List<Duty> findByLastName(String lastName, Pageable pageable) {
        return queryTemplate.selectMany(Duty.class)
                .withQuery(FIND_BY_LAST_NAME_QUERY)
                .withParam(SqlUtil.startsWith(lastName))
                .withParam(pageable)
                .execute();
    }
}
