package com.room414.hospital.domain.entities;

import com.google.common.base.CaseFormat;

import static com.google.common.base.Strings.nullToEmpty;

public enum Secession {
    ORTHOPEDICS,
    THERAPY,
    PEDIATRICS,
    REHABILITATION,
    GYNECOLOGY,
    NOT_DEFINED;

    public static Secession of(final String name) {
        for (final Secession value : values()) {
            if (value.name().equals(toUnderscore(name))) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return toCamel(name());
    }

    private static String toCamel(String value) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, nullToEmpty(value));
    }

    private static String toUnderscore(String value) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, nullToEmpty(value));
    }
}
