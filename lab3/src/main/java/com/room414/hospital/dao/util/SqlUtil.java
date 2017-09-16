package com.room414.hospital.dao.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SqlUtil {

    public String startsWith(String value) {
        return value + "%";
    }
}
