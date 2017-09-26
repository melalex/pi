package com.room414.hospital.services;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.internal.DoctorCriteria;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.AccountForm;

public interface DoctorService {

    void create(AccountForm form);

    boolean isDoctorNotExist(String username);

    Doctor findByUsername(String username);

    Page<Doctor> findByCriteria(DoctorCriteria criteria, Pageable pageable);
}
