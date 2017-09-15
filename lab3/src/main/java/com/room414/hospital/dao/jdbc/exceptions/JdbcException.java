package com.room414.hospital.dao.jdbc.exceptions;

public class JdbcException extends RuntimeException {

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