package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.resolvers.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;

@Resolver(DutyForm.class)
public class DutyFormResolver implements ArgumentResolver<DutyForm> {

    @Override
    public DutyForm resolve(HttpServletRequest request) {
        return null;
    }
}
