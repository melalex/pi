package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.resolvers.ArgumentResolver;
import com.room414.hospital.utils.ResolverUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Resolver(DutyForm.class)
public class DutyFormResolver implements ArgumentResolver<DutyForm> {
    private static final String DOCTOR_PARAM = "doctor";
    private static final String DATE_PARAM = "date";

    @Override
    public DutyForm resolve(HttpServletRequest request) {
        DutyForm dutyForm = new DutyForm();

        dutyForm.setDoctor(request.getParameter(DOCTOR_PARAM));
        dutyForm.setDate(ResolverUtils.parseDate(request.getParameter(DATE_PARAM)));

        return dutyForm;
    }
}
