package com.room414.hospital.dao.mapping.impl;

import com.room414.hospital.domain.entities.ApplicationUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationUserMapper extends AbstractRowMapper<ApplicationUser> {
    private static final String USERNAME_COLUMN_NAME = "application_user.doctor";
    private static final String PASSWORD_COLUMN_NAME = "application_user.password";

    @Override
    protected ApplicationUser mapEntity(ResultSet resultSet) throws SQLException {
        ApplicationUser applicationUser = new ApplicationUser();

        applicationUser.setUsername(resultSet.getString(USERNAME_COLUMN_NAME));
        applicationUser.setUsername(resultSet.getString(PASSWORD_COLUMN_NAME));

        return applicationUser;
    }

    @Override
    public Class<ApplicationUser> support() {
        return ApplicationUser.class;
    }
}
