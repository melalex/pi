package com.room414.hospital.dao.mapping;

import java.sql.ResultSet;

@FunctionalInterface
public interface RowExtractor<T> {

    T extract(ResultSet resultSet);
}
