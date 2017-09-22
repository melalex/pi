package com.room414.hospital.services;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Patient;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.PatientForm;

public interface PatientService {

    void save(PatientForm form);

    Patient findById(Long id);

    Page<Patient> findAll(Pageable pageable);
}
