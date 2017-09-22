package com.room414.hospital.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@UtilityClass
public class ResolverUtils {
    private static final String ID_PARAM = "id";
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm";

    public Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

        try {
            return new Date(formatter.parse(dateString).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public int parseInteger(String integer, int defaultValue) {
        try {
            return Integer.parseInt(integer);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public String getStringId(HttpServletRequest request) {
        return request.getParameter(ID_PARAM);
    }

    public Long getLongId(HttpServletRequest request) {
        try {
            return Long.parseLong(request.getParameter(ID_PARAM));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}