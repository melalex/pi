package com.room414.hospital.utils;

import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@UtilityClass
public class ResolverUtils {
    private final static String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm";

    public static Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

        try {
            return new Date(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}
