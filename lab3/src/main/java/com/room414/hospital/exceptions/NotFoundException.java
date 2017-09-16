package com.room414.hospital.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1634302885313702045L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Object... objects) {
        super(String.format(message, objects));
    }
}
