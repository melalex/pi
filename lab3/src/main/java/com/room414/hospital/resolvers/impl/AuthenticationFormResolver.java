package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.AuthenticationForm;
import com.room414.hospital.resolvers.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;

@Resolver(AuthenticationForm.class)
public class AuthenticationFormResolver implements ArgumentResolver<AuthenticationForm> {
    private static final String USERNAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";

    @Override
    public AuthenticationForm resolve(HttpServletRequest request) {
        AuthenticationForm authenticationForm = new AuthenticationForm();

        authenticationForm.setUsername(request.getParameter(USERNAME_PARAM));
        authenticationForm.setPassword(request.getParameter(PASSWORD_PARAM));

        return authenticationForm;
    }
}
