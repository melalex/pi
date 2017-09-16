package com.room414.hospital.dao.impl;

import com.room414.hospital.dao.DutyDao;
import com.room414.hospital.dao.mapping.RowExtractor;
import com.room414.hospital.dao.mapping.impl.CountExtractor;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.dao.util.SqlUtil;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.ApplicationUser;
import com.room414.hospital.domain.entities.Duty;
import lombok.AllArgsConstructor;
import org.intellij.lang.annotations.Language;

import java.util.List;

@AllArgsConstructor
public class DutyDaoImpl implements DutyDao {
    // @formatter:off

    @Language("MySQL")
    private static final String CREATE_QUERY =
            "INSERT INTO duty (doctor, date) " +
            "VALUES (?, ?)";

    @Language("MySQL")
    private static final String FIND_BY_LAST_NAME_QUERY =
            "SELECT * " +
            "FROM duty " +
            "   LEFT JOIN doctor " +
            "       ON doctor.application_user = duty.doctor " +
            "WHERE doctor.last_name LIKE ? LIMIT ? OFFSET ?";

    @Language("MySQL")
    private static final String COUNT_BY_LAST_NAME_QUERY =
            "SELECT COUNT(*) " +
            "FROM duty " +
            "   LEFT JOIN doctor " +
            "       ON doctor.application_user = duty.doctor " +
            "WHERE doctor.last_name LIKE ?";

    // @formatter:on

    private QueryTemplate queryTemplate;

    private final RowExtractor<Integer> countExtractor = new CountExtractor();

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

    @Override
    public Integer countByLastName(String lastName) {
        return queryTemplate.aggregate(countExtractor)
                .withQuery(COUNT_BY_LAST_NAME_QUERY)
                .withParam(SqlUtil.startsWith(lastName))
                .execute();
    }
}
