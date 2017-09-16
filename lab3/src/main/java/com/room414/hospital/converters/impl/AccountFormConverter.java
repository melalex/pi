package com.room414.hospital.converters.impl;

import com.room414.hospital.converters.Converter;
import com.room414.hospital.domain.entities.ApplicationUser;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.entities.Secession;
import com.room414.hospital.forms.AccountForm;

public class AccountFormConverter implements Converter<AccountForm, Doctor> {

    @Override
    public Doctor convert(AccountForm source) {
        Doctor doctor = new Doctor();

        doctor.setApplicationUser(toUser(source));
        doctor.setFirstName(source.getFirstName());
        doctor.setLastName(source.getLastName());
        doctor.setSecession(Secession.of(source.getSecession()));

        return doctor;
    }

    private ApplicationUser toUser(AccountForm source) {
        ApplicationUser user = new ApplicationUser();

        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());

        return user;
    }

}
