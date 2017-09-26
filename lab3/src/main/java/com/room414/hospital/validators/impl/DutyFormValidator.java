package com.room414.hospital.validators.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.services.DoctorService;

import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class DutyFormValidator extends AbstractValidator<DutyForm> {
    private static final String DOCTOR_IS_EMPTY = "errors.validation.doctor.empty";
    private static final String DOCTOR_NOT_FOUND = "errors.validation.doctor.notFound";

    private static final String DATE_IS_EMPTY = "errors.validation.date.empty";

    private final DoctorService doctorService = ApplicationContext.getInstance().getDoctorService();

    @Override
    protected void validate(DutyForm object, List<String> errorCodes) {
        if (isBlank(object.getDoctor())) {
            errorCodes.add(DOCTOR_IS_EMPTY);
        }

        if (isNotBlank(object.getDoctor()) && doctorService.isDoctorNotExist(object.getDoctor())) {
            errorCodes.add(DOCTOR_NOT_FOUND);
        }

        if (isNull(object.getDate())) {
            errorCodes.add(DATE_IS_EMPTY);
        }
    }
}
