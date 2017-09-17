package com.room414.hospital.services.impl;

import com.room414.hospital.services.MessageService;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageServiceImpl implements MessageService {
    private static final String RESOURCE_BUNDLE = "i18n/ErrorMessage";

    @Override
    public String message(String key, Locale locale) {
        return ResourceBundle.getBundle(RESOURCE_BUNDLE, locale).getString(key);
    }
}
