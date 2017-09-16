package com.room414.hospital.services;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.internal.DoctorCriteria;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.forms.AuthenticationForm;

import java.util.List;

public interface DoctorService {

    void create(AccountForm form);

    boolean isDoctorExists(String username);

    Doctor findByUsername(String username);

    Page<Doctor> findByCriteria(DoctorCriteria criteria, Pageable pageable);
}
