package com.room414.hospital.dao.jdbc.impl;

import com.room414.hospital.dao.jdbc.exceptions.JdbcException;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public abstract class JdbcSupport<T> implements AutoCloseable {
    private final Connection connection;

    T query(String sql, Object... params) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setValues(statement, params);

            return executeQuery(statement);
        } catch (SQLException e) {
            String message = String.format("Exception during calling procedure '%s'", sqlFormat(sql, params));

            throw new JdbcException(message, e);
        }
    }

    protected abstract T executeQuery(PreparedStatement statement) throws SQLException;


    private void setValues(PreparedStatement preparedStatement, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
    }

    private String sqlFormat(String sqlPattern, Object... arguments) {
        String sqlStatement = sqlPattern
                .replaceAll("\\?", "%s")
                .replaceAll("\\s+", " ");

        return String.format(sqlStatement, arguments);
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new JdbcException("Can't commit transaction", e);
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new JdbcException("Can't rollback transaction", e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new JdbcException("Can't close connection", e);
        }
    }
}
