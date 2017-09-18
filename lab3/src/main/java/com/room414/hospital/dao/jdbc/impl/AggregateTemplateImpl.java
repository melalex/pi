package com.room414.hospital.dao.jdbc.impl;

import com.room414.hospital.dao.jdbc.AggregateTemplate;
import com.room414.hospital.dao.mapping.RowExtractor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AggregateTemplateImpl<T> extends AbstractTemplate<T> implements AggregateTemplate<T> {
    private final RowExtractor<T> rowExtractor;

    public AggregateTemplateImpl(Connection connection, RowExtractor<T> rowExtractor) {
        super(connection);

        this.rowExtractor = rowExtractor;
    }

    @Override
    public T aggregate(String sql, Object... params) {
        return query(sql, params);
    }

    @Override
    protected T executeQuery(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            T result = null;

            if (resultSet.next()) {
                result = rowExtractor.extract(resultSet);
            }

            return result;
        }
    }
}
