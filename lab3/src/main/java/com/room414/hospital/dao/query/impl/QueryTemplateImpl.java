package com.room414.hospital.dao.query.impl;

import com.room414.hospital.dao.jdbc.SelectTemplate;
import com.room414.hospital.dao.jdbc.UpdateTemplate;
import com.room414.hospital.dao.jdbc.exceptions.JdbcException;
import com.room414.hospital.dao.jdbc.impl.SelectTemplateImpl;
import com.room414.hospital.dao.jdbc.impl.UpdateTemplateImpl;
import com.room414.hospital.dao.mapping.providers.MappingProvider;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.dao.query.builder.QueryBuilder;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class QueryTemplateImpl implements QueryTemplate {
    private DataSource dataSource;
    private MappingProvider mappingProvider;


    @Override
    public QueryBuilder<Integer> update() {
        UpdateTemplate template = new UpdateTemplateImpl(connection());

        return new QueryBuilder<>(template::update);
    }

    @Override
    public <T> QueryBuilder<Optional<T>> selectOne(Class<T> clazz) {
        SelectTemplate<T> template = new SelectTemplateImpl<>(connection(), mappingProvider.provide(clazz));

        return new QueryBuilder<>(template::queryOne);
    }

    @Override
    public <T> QueryBuilder<List<T>> selectMany(Class<T> clazz) {
        SelectTemplate<T> template = new SelectTemplateImpl<>(connection(), mappingProvider.provide(clazz));

        return new QueryBuilder<>(template::queryList);
    }

    private Connection connection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new JdbcException("Can't get connection", e);
        }
    }
}
