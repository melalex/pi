package com.room414.hospital.services.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.converters.Converter;
import com.room414.hospital.dao.PatientDao;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Patient;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.PatientForm;
import com.room414.hospital.services.PatientService;
import com.room414.hospital.utils.ErrorUtils;
import com.room414.hospital.validators.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.room414.hospital.utils.PaginationUtils.withCount;

@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao = ApplicationContext.getInstance().getPatientDao();
    private final Validator<PatientForm> patientFormValidator = ApplicationContext.getInstance().getPatientFormValidator();
    private final Converter<PatientForm, Patient> patientConverter = ApplicationContext.getInstance().getPatientFormConverter();

    @Override
    public void create(PatientForm form) {
        patientFormValidator.validate(form);
        patientDao.create(patientConverter.convert(form));
        log.info("Create new Patient {}", form);
    }

    @Override
    public void update(long id, PatientForm form) {
        patientFormValidator.validate(form);
        patientDao.update(toPatient(id, form));
        log.info("Update with id {} and value {}", id, form);
    }

    @Override
    public Patient findById(long id) {
        return patientDao
                .findOne(id)
                .orElseThrow(ErrorUtils.notFound("Patient", "id", id));
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {
        List<Patient> content = patientDao.findAll(pageable);
        Pageable counted = withCount(pageable, patientDao.countAll());

        return Page.of(content, counted);
    }

    private Patient toPatient(long id, PatientForm form) {
        Patient patient = patientConverter.convert(form);
        patient.setId(id);

        return patient;
    }
}
