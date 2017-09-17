package com.room414.hospital.dao.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.dao.ApplicationUserDao;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.domain.entities.ApplicationUser;
import org.intellij.lang.annotations.Language;

import java.util.Optional;

public class ApplicationUserDaoImpl implements ApplicationUserDao {
    // @formatter:off

    @Language("MySQL")
    private static final String CREATE_QUERY =
            "INSERT INTO application_user (username, password) " +
            "VALUES (?, ?)";

    @Language("MySQL")
    private static final String FIND_BY_USERNAME_QUERY =
            "SELECT * " +
            "FROM application_user " +
            "WHERE username = ?";

    @Language("MySQL")
    private static final String FIND_BY_USERNAME_AND_PASSWORD_QUERY =
            "SELECT * " +
            "FROM application_user " +
            "WHERE username = ? AND password = ?";

    // @formatter:on

    private final QueryTemplate queryTemplate = ApplicationContext.getInstance().getQueryTemplate();

    @Override
    public void create(ApplicationUser applicationUser) {
        queryTemplate.update()
                .withQuery(CREATE_QUERY)
                .withParam(applicationUser.getUsername())
                .withParam(applicationUser.getPassword())
                .execute();
    }

    @Override
    public Optional<ApplicationUser> findByUsername(String username) {
        return queryTemplate.selectOne(ApplicationUser.class)
                .withQuery(FIND_BY_USERNAME_QUERY)
                .withParam(username)
                .execute();
    }

    @Override
    public Optional<ApplicationUser> findByUsernameAndPassword(String username, String password) {
        return queryTemplate.selectOne(ApplicationUser.class)
                .withQuery(FIND_BY_USERNAME_AND_PASSWORD_QUERY)
                .withParam(username)
                .withParam(password)
                .execute();
    }
}
