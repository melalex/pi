package com.room414.hospital.services.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.services.LocaleService;

import java.util.Locale;
import java.util.Map;

public class LocaleServiceImpl implements LocaleService {
    private final Map<String, Locale> supportedLocales = ApplicationContext.getInstance().getSupportedLocales();
    private final Locale defaultLocale = ApplicationContext.getInstance().getDefaultLocale();

    @Override
    public Locale getDefault() {
        return defaultLocale;
    }

    @Override
    public Locale getLocaleOrDefault(String locale) {
        return supportedLocales.getOrDefault(locale, defaultLocale);
    }
}
