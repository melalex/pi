package com.room414.hospital.utils;

import com.room414.hospital.exceptions.NotFoundException;
import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class ErrorUtils {

    public Supplier<NotFoundException> notFound(String entity, String field, Object value) {
        return () -> new NotFoundException("There is no %s with %s equals %s", entity, field, value);
    }
}
