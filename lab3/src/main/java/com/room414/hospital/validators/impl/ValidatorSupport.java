package com.room414.hospital.validators.impl;

import com.google.common.collect.Lists;
import com.room414.hospital.exceptions.ValidationException;
import com.room414.hospital.validators.Validator;

import java.util.List;

public abstract class ValidatorSupport<T> implements Validator<T> {

    @Override
    public void validate(T object) {
        List<String> errorCodes = Lists.newLinkedList();

        validate(object, errorCodes);

        if (!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes, "Subject is invalid");
        }

    }

    protected abstract void validate(T object, List<String> errorCodes);
}
