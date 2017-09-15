package com.room414.hospital.dao.mapping;

import java.sql.ResultSet;

@FunctionalInterface
public interface RowMapper<T> {

    T map(ResultSet resultSet);
}