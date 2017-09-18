package com.room414.hospital.exceptions;

public class ResolveException extends RuntimeException {
    private static final long serialVersionUID = -7511232394984132784L;

    public ResolveException() {
        super();
    }

    public ResolveException(String message) {
        super(message);
    }

    public ResolveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResolveException(Throwable cause) {
        super(cause);
    }
}
