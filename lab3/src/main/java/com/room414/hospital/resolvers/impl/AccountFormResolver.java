package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.resolvers.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;

@Resolver(AccountForm.class)
public class AccountFormResolver implements ArgumentResolver<AccountForm> {
    private static final String USERNAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";
    private static final String RETRY_PASSWORD_PARAM = "retryPassword";
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String SECESSION_PARAM = "secession";

    @Override
    public AccountForm resolve(HttpServletRequest request) {
        AccountForm accountForm = new AccountForm();

        accountForm.setUsername(request.getParameter(USERNAME_PARAM));
        accountForm.setPassword(request.getParameter(PASSWORD_PARAM));
        accountForm.setRetryPassword(request.getParameter(RETRY_PASSWORD_PARAM));
        accountForm.setFirstName(request.getParameter(FIRST_NAME_PARAM));
        accountForm.setLastName(request.getParameter(LAST_NAME_PARAM));
        accountForm.setSecession(request.getParameter(SECESSION_PARAM));

        return accountForm;
    }
}
