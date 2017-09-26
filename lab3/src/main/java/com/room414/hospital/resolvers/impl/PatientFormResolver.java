package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.forms.PatientForm;
import com.room414.hospital.resolvers.ArgumentResolver;
import com.room414.hospital.utils.ResolverUtils;

import javax.servlet.http.HttpServletRequest;

@Resolver(PatientForm.class)
public class PatientFormResolver implements ArgumentResolver<PatientForm> {
    private static final String FIRST_NAME_PARAM = "firstName";
    private static final String LAST_NAME_PARAM = "lastName";
    private static final String DESCRIPTION_PARAM = "description";
    private static final String DOCTOR_PARAM = "doctor";

    @Override
    public PatientForm resolve(HttpServletRequest request) {
        PatientForm patientForm = new PatientForm();

        patientForm.setId(ResolverUtils.getLongId(request));
        patientForm.setFirstName(request.getParameter(FIRST_NAME_PARAM));
        patientForm.setLastName(request.getParameter(LAST_NAME_PARAM));
        patientForm.setDescription(request.getParameter(DESCRIPTION_PARAM));
        patientForm.setDoctor(request.getParameter(DOCTOR_PARAM));

        return patientForm;
    }
}
