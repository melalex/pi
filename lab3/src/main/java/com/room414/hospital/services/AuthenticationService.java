package com.room414.hospital.services;

import com.room414.hospital.forms.AuthenticationForm;

public interface AuthenticationService {

    boolean tryAuthenticate(AuthenticationForm form);
}
