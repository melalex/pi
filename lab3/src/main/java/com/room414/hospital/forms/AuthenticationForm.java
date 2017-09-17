package com.room414.hospital.forms;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationForm implements Serializable {
    private static final long serialVersionUID = -7556222265072686562L;

    private String username;
    private String password;
}
