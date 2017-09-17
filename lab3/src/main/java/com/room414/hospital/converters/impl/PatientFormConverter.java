package com.room414.hospital.converters.impl;

import com.room414.hospital.converters.Converter;
import com.room414.hospital.domain.entities.Patient;
import com.room414.hospital.forms.PatientForm;
import com.room414.hospital.utils.ConversionUtil;

public class PatientFormConverter implements Converter<PatientForm, Patient> {

    @Override
    public Patient convert(PatientForm source) {
        Patient patient = new Patient();

        patient.setFirstName(source.getFirstName());
        patient.setLastName(source.getLastName());
        patient.setDescription(source.getDescription());
        patient.setDoctor(ConversionUtil.toDoctor(source.getDoctor()));

        return patient;
    }
}
