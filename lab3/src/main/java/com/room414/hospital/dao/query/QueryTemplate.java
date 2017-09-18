package com.room414.hospital.dao.query;

import com.room414.hospital.dao.mapping.RowExtractor;
import com.room414.hospital.dao.query.builder.QueryBuilder;

import java.util.List;
import java.util.Optional;

public interface QueryTemplate {

    QueryBuilder<Integer> update();

    <T> QueryBuilder<T> aggregate(RowExtractor<T> rowExtractor);

    <T> QueryBuilder<Optional<T>> selectOne(Class<T> clazz);

    <T> QueryBuilder<List<T>> selectMany(Class<T> clazz);
}
