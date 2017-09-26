package com.room414.hospital.dao.mapping.impl;

import com.room414.hospital.dao.mapping.RowExtractor;
import com.room414.hospital.exceptions.JdbcException;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRowExtractor<T> implements RowExtractor<T> {

    @Override
    public T extract(ResultSet resultSet) {
        try {
            return extractValue(resultSet);
        } catch (SQLException e) {
            throw new JdbcException("Can't extract value", e);
        }
    }

    protected abstract T extractValue(ResultSet resultSet) throws SQLException;

}
