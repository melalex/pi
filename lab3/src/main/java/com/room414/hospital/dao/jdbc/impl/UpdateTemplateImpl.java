package com.room414.hospital.dao.jdbc.impl;

import com.room414.hospital.dao.jdbc.UpdateTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTemplateImpl extends JdbcSupport<Integer> implements UpdateTemplate {

    public UpdateTemplateImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int update(String sql, Object... params) {
        return query(sql, params);
    }

    @Override
    protected Integer executeQuery(PreparedStatement statement) throws SQLException {
        return statement.executeUpdate();
    }
}