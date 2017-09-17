package com.room414.hospital.contexts;

import com.room414.hospital.converters.Converter;
import com.room414.hospital.converters.impl.AccountFormConverter;
import com.room414.hospital.converters.impl.DutyFormConverter;
import com.room414.hospital.converters.impl.PatientFormConverter;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.entities.Duty;
import com.room414.hospital.domain.entities.Patient;
import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.forms.PatientForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class ConversionContext {

    @Getter(lazy = true)
    private final Converter<AccountForm, Doctor> accountFormConverter = new AccountFormConverter();

    @Getter(lazy = true)
    private final Converter<DutyForm, Duty> dutyFormConverter = new DutyFormConverter();

    @Getter(lazy = true)
    private final Converter<PatientForm, Patient> patientFormConverter = new PatientFormConverter();
}
