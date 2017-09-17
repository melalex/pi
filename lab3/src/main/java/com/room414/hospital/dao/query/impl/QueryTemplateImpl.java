package com.room414.hospital.dao.query.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.dao.jdbc.AggregateTemplate;
import com.room414.hospital.dao.jdbc.SelectTemplate;
import com.room414.hospital.dao.jdbc.UpdateTemplate;
import com.room414.hospital.dao.jdbc.impl.AggregateTemplateImpl;
import com.room414.hospital.dao.jdbc.impl.SelectTemplateImpl;
import com.room414.hospital.dao.jdbc.impl.UpdateTemplateImpl;
import com.room414.hospital.dao.mapping.RowExtractor;
import com.room414.hospital.dao.mapping.providers.MappingProvider;
import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.dao.query.builder.QueryBuilder;
import com.room414.hospital.exceptions.JdbcException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class QueryTemplateImpl implements QueryTemplate {
    private final DataSource dataSource = ApplicationContext.getInstance().getDataSource();
    private final MappingProvider mappingProvider = ApplicationContext.getInstance().getMappingProvider();

    @Override
    public QueryBuilder<Integer> update() {
        UpdateTemplate template = new UpdateTemplateImpl(connection());

        return new QueryBuilder<>(template::update);
    }

    @Override
    public <T> QueryBuilder<T> aggregate(RowExtractor<T> rowExtractor) {
        AggregateTemplate<T> template = new AggregateTemplateImpl<>(connection(), rowExtractor);

        return new QueryBuilder<>(template::aggregate);
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
