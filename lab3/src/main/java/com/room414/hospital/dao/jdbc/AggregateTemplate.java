package com.room414.hospital.dao.jdbc;

public interface AggregateTemplate<T> {

    T aggregate(String sql, Object... params);
}
