package com.room414.hospital.exceptions;

public class StartUpException extends RuntimeException {
    private static final long serialVersionUID = 6412512300758366870L;

    public StartUpException() {
        super();
    }

    public StartUpException(String message) {
        super(message);
    }

    public StartUpException(String message, Throwable cause) {
        super(message, cause);
    }

    public StartUpException(String message, Object... objects) {
        super(String.format(message, objects));
    }
}
