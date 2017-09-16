package com.room414.hospital.dao;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientDao {

    void create(Patient patient);

    void update(Patient patient);

    Optional<Patient> findOne(long id);

    List<Patient> findAll(Pageable pageable);
}
