package com.room414.hospital.dao.mapping.impl;

import com.room414.hospital.exceptions.JdbcException;
import com.room414.hospital.dao.mapping.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRowMapper<T> implements RowMapper<T> {

    @Override
    public T map(ResultSet resultSet) {
        try {
            return mapEntity(resultSet);
        } catch (SQLException e) {
            throw new JdbcException("Can't map entity", e);
        }
    }

    protected abstract T mapEntity(ResultSet resultSet) throws SQLException ;
}
