package com.room414.hospital.exceptions;

public class JdbcException extends RuntimeException {
    private static final long serialVersionUID = -5091473454160593478L;

    public JdbcException() {
    }

    public JdbcException(String message) {
        super(message);
    }

    public JdbcException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcException(Throwable cause) {
        super(cause);
    }
}