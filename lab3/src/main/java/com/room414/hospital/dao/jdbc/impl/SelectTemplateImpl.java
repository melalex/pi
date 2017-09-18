package com.room414.hospital.dao.jdbc.impl;

import com.room414.hospital.dao.jdbc.SelectTemplate;
import com.room414.hospital.dao.mapping.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SelectTemplateImpl<T> extends AbstractTemplate<List<T>> implements SelectTemplate<T> {
    private final RowMapper<T> rowMapper;

    public SelectTemplateImpl(Connection connection, RowMapper<T> rowMapper) {
        super(connection);

        this.rowMapper = rowMapper;
    }

    @Override
    public Optional<T> queryOne(String sql, Object... params) {
        return queryList(sql, params).stream().findFirst();
    }

    @Override
    public List<T> queryList(String sql, Object... params) {
        return query(sql, params);
    }

    @Override
    protected List<T> executeQuery(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            List<T> result = new LinkedList<>();

            while (resultSet.next()) {
                result.add(rowMapper.map(resultSet));
            }

            return result;
        }
    }
}
