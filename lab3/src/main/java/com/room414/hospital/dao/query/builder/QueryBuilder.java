package com.room414.hospital.dao.query.builder;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.room414.hospital.dao.query.BuildCallback;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class QueryBuilder<T> {

    @NonNull
    private final BuildCallback<T> callback;

    private String sql;
    private List<Object> params = Lists.newLinkedList();

    public QueryBuilder<T> withQuery(String sql) {
        this.sql = sql;
        return this;
    }

    public QueryBuilder<T> withParam(Object param) {
        this.params.add(param);
        return this;
    }

    public QueryBuilder<T> withParams(Object... params) {
        this.params.addAll(Arrays.asList(params));
        return this;
    }

    private T execute() {
        Preconditions.checkNotNull(sql);

        return callback.onBuild(sql, params);
    }
}