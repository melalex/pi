package com.room414.hospital.dao.jdbc;

public interface UpdateTemplate extends AutoCloseable {

    int update(String sql, Object... params);

    void commit();

    void rollback();
}
