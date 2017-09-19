package com.room414.hospital.services;

import com.room414.hospital.forms.AuthenticationForm;

public interface UserService {

    boolean isUserExists(String username);

    void tryAuthenticate(AuthenticationForm form);
}
