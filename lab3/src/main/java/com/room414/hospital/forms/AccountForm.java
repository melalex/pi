package com.room414.hospital.forms;

import lombok.Data;

@Data
public class AccountForm {
    private String username;
    private String password;
    private String retryPassword;
    private String firstName;
    private String lastName;
    private String secession;
}
