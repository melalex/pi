package com.room414.hospital.dao.query.internal;

import com.google.common.collect.Lists;
import com.room414.hospital.dao.query.BuildCallback;
import com.room414.hospital.dao.query.CompleteCallback;
import com.room414.hospital.domain.Identifiable;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.utils.SqlUtil;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@RequiredArgsConstructor
public class QueryBuilder<T> {

    @NonNull
    private final BuildCallback<T> buildCallback;

    @NonNull
    private final CompleteCallback completeCallback;

    private String sql;

    @AllArgsConstructor
    public static class ParamsBuilder<T> {
        private final QueryBuilder<T> queryBuilder;
        private final List<Object> params = Lists.newLinkedList();

        public ParamsBuilder<T> withParam(Object param) {
            this.params.add(param);
            return this;
        }

        public ParamsBuilder<T> withParam(Identifiable<?> param) {
            return withParam(param.getId());
        }

        public ParamsBuilder<T> withParam(Pageable param) {
            this.params.add(param.getLimit());
            this.params.add(param.getOffset());
            return this;
        }

        public ParamsBuilder<T> withParam(Enum<?> anEnum) {
            return withParam(Objects.nonNull(anEnum) ? anEnum.toString() : null);
        }

        public ParamsBuilder<T> withParams(Object param, Object... params) {
            this.params.add(param);
            this.params.addAll(Arrays.asList(params));
            return this;
        }

        public T execute() {
            return queryBuilder.execute(params.toArray());
        }
    }

    public ParamsBuilder<T> withQuery(String sql) {
        this.sql = sql;
        return new ParamsBuilder<>(this);
    }

    private T execute(Object... params) {
        checkArgument(isNotBlank(sql), "Query can't be Blank");

        log.debug("Execute query {}", SqlUtil.sqlFormat(sql, params));

        T result = buildCallback.onBuild(sql, params);

        completeCallback.onComplete();

        return result;
    }
}