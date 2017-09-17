package com.room414.hospital.services;

import java.util.Locale;

public interface LocaleService {

    Locale getDefault();

    Locale getLocaleOrDefault(String locale);
}
