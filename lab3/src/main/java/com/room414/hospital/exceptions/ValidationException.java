package com.room414.hospital.exceptions;

import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 4914780254554315527L;

    @Getter
    private List<String> errorCodes;

    @Getter
    private Object subject;

    public ValidationException(Object subject, List<String> errorCodes) {
        super();

        this.subject = subject;
        this.errorCodes = errorCodes;
    }

    public ValidationException(Object subject, List<String> errorCodes, String message) {
        super(message);

        this.subject = subject;
        this.errorCodes = errorCodes;
    }
}
