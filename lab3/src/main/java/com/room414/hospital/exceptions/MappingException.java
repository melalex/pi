package com.room414.hospital.exceptions;

public class MappingException extends RuntimeException {
    private static final long serialVersionUID = -5077260598548711173L;

    public MappingException() {
        super();
    }

    public MappingException(String message) {
        super(message);
    }

    public MappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MappingException(Throwable cause) {
        super(cause);
    }
}
