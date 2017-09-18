package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.PatientForm;
import com.room414.hospital.resolvers.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;

@Resolver(PatientForm.class)
public class PatientFormResolver implements ArgumentResolver<PatientForm> {

    @Override
    public PatientForm resolve(HttpServletRequest request) {
        return null;
    }
}
