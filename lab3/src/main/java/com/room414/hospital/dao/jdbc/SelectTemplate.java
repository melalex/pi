package com.room414.hospital.dao.jdbc;

import java.util.List;
import java.util.Optional;

public interface SelectTemplate<T> extends AutoCloseable {

    Optional<T> queryOne(String sql, Object... params);

    List<T> queryList(String sql, Object... params);

    @Override
    void close();
}
