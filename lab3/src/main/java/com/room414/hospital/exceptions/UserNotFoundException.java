package com.room414.hospital.exceptions;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6814838042819044879L;

    @Getter
    private String username;

    public UserNotFoundException(String username) {
        this.username = username;
    }
}
