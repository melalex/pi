package com.room414.hospital.dao.impl;

import com.room414.hospital.dao.ApplicationUserDao;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.domain.entities.ApplicationUser;
import lombok.AllArgsConstructor;
import org.intellij.lang.annotations.Language;

import java.util.Optional;

@AllArgsConstructor
public class ApplicationUserDaoImpl implements ApplicationUserDao {
    // @formatter:off

    @Language("MySQL")
    private static final String CREATE_QUERY =
            "INSERT INTO application_user (username, password) " +
            "VALUES (?, ?)";

    @Language("MySQL")
    private static final String FIND_BY_USERNAME_AND_PASSWORD_QUERY =
            "SELECT * " +
            "FROM application_user " +
            "WHERE username = ? AND password = ?";

    // @formatter:on

    private QueryTemplate queryTemplate;

    @Override
    public void create(ApplicationUser applicationUser) {
        queryTemplate.update()
                .withQuery(CREATE_QUERY)
                .withParam(applicationUser.getUsername())
                .withParam(applicationUser.getPassword())
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
