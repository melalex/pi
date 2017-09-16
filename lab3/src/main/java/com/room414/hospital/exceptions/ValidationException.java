package com.room414.hospital.exceptions;

import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 4914780254554315527L;

    @Getter
    private List<String> errorCodes;

    public ValidationException(List<String> errorCodes) {
        super();

        this.errorCodes = errorCodes;
    }

    public ValidationException(List<String> errorCodes, String message) {
        super(message);

        this.errorCodes = errorCodes;
    }
}
