package com.room414.hospital.dao.mapping.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountExtractor extends AbstractRowExtractor<Integer> {
    private static final String COUNT_COLUMN = "COUNT(*)";

    @Override
    public Integer extractValue(ResultSet resultSet) throws SQLException {
        return resultSet.getInt(COUNT_COLUMN);
    }
}
