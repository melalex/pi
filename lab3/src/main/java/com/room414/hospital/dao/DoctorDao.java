package com.room414.hospital.dao;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.entities.Secession;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DoctorDao {

    void create(Doctor patient);

    void update(Doctor patient);

    Optional<Doctor> findOne(String username);

    List<Doctor> findAll(Pageable pageable);

    List<Doctor> findByDuty(Date date, Pageable pageable);

    List<Doctor> findBySecession(Secession secession);
}
