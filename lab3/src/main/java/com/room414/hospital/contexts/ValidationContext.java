package com.room414.hospital.contexts;

import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.forms.PatientForm;
import com.room414.hospital.validators.Validator;
import com.room414.hospital.validators.impl.AccountFormValidator;
import com.room414.hospital.validators.impl.DutyFormValidator;
import com.room414.hospital.validators.impl.PatientFormValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class ValidationContext {

    @Getter(lazy = true)
    private final Validator<AccountForm> accountFormValidator = new AccountFormValidator();

    @Getter(lazy = true)
    private final Validator<DutyForm> dutyFormValidator = new DutyFormValidator();

    @Getter(lazy = true)
    private final Validator<PatientForm> patientFormValidator = new PatientFormValidator();
}
