package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.AuthenticationForm;
import com.room414.hospital.resolvers.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;

@Resolver(AuthenticationForm.class)
public class AuthenticationFormResolver implements ArgumentResolver<AuthenticationForm> {

    @Override
    public AuthenticationForm resolve(HttpServletRequest request) {
        return null;
    }
}
