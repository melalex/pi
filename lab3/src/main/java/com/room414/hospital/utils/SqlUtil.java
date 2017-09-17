package com.room414.hospital.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SqlUtil {

    public String startsWith(String value) {
        return value + "%";
    }
}
