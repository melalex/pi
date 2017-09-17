package com.room414.hospital.validators.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.forms.PatientForm;
import com.room414.hospital.services.DoctorService;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class PatientFormValidator extends ValidatorSupport<PatientForm> {
    private static final String DOCTOR_IS_EMPTY = "errors.validation.doctor.empty";
    private static final String DOCTOR_NOT_FOUND = "errors.validation.doctor.notFound";

    private static final String FIRST_NAME_IS_EMPTY = "errors.validation.firstName.empty";
    private static final String LAST_NAME_IS_EMPTY = "errors.validation.lastName.empty";

    private final DoctorService doctorService = ApplicationContext.getInstance().getDoctorService();

    @Override
    protected void validate(PatientForm object, List<String> errorCodes) {
        if (isBlank(object.getDoctor())) {
            errorCodes.add(DOCTOR_IS_EMPTY);
        }

        if (isNotBlank(object.getDoctor()) && doctorService.isDoctorExists(object.getDoctor())) {
            errorCodes.add(DOCTOR_NOT_FOUND);
        }

        if (isBlank(object.getFirstName())) {
            errorCodes.add(FIRST_NAME_IS_EMPTY);
        }

        if (isBlank(object.getLastName())) {
            errorCodes.add(LAST_NAME_IS_EMPTY);
        }
    }
}
