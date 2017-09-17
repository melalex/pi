package com.room414.hospital.forms;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountForm implements Serializable {
    private static final long serialVersionUID = 3866726551087971256L;

    private String username;
    private String password;
    private String retryPassword;
    private String firstName;
    private String lastName;
    private String secession;
}
