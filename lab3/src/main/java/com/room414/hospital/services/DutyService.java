package com.room414.hospital.services;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Duty;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.DutyForm;

public interface DutyService {

    void create(DutyForm form);

    Page<Duty> findByLastName(String lastName, Pageable pageable);
}
