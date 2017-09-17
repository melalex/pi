package com.room414.hospital.dao.mapping;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T map(ResultSet resultSet);

    Class<T> support();
}