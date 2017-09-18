package com.room414.hospital.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SqlUtil {

    public String startsWith(String value) {
        return value + "%";
    }

    public String sqlFormat(String sqlPattern, Object... arguments) {
        String sqlStatement = sqlPattern
                .replaceAll("\\?", "%s")
                .replaceAll("\\s+", " ");

        return String.format(sqlStatement, arguments);
    }
}
