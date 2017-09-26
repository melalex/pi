package com.room414.hospital.dao.jdbc;

public interface AggregateTemplate<T> extends AutoCloseable {

    T aggregate(String sql, Object... params);

    @Override
    void close();
}
