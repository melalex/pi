package com.room414.hospital.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@UtilityClass
public class SessionUtil {
    public final static String LANG = "lang";
    public final static String LOCALE = "locale";
    public final static String USER_ATTR = "applicationUser";

    public Locale locale(HttpServletRequest request) {
        return (Locale) request.getSession().getAttribute(LOCALE);
    }
}
