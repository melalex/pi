package com.room414.hospital.dao.mapping;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T map(ResultSet resultSet);

    boolean supportsClass(Class<?> clazz);
}