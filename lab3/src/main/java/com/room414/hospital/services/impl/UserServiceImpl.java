package com.room414.hospital.services.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.dao.ApplicationUserDao;
import com.room414.hospital.exceptions.UserNotFoundException;
import com.room414.hospital.forms.AuthenticationForm;
import com.room414.hospital.services.UserService;

public class UserServiceImpl implements UserService {
    private final ApplicationUserDao applicationUserDao = ApplicationContext.getInstance().getApplicationUserDao();

    @Override
    public boolean isUserExists(String username) {
        return applicationUserDao
                .findByUsername(username)
                .isPresent();
    }

    @Override
    public boolean tryAuthenticate(AuthenticationForm form) {
        return applicationUserDao
                .findByUsernameAndPassword(form.getUsername(), form.getPassword())
                .isPresent();
    }
}
