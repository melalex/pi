package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.resolvers.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;

@Resolver(AccountForm.class)
public class AccountFormResolver implements ArgumentResolver<AccountForm> {

    @Override
    public AccountForm resolve(HttpServletRequest request) {
        return null;
    }
}
