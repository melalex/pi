package com.room414.hospital.dao;

import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Duty;

import java.util.List;

public interface DutyDao {

    void create(Duty duty);

    List<Duty> findByLastName(String lastName, Pageable pageable);

    Integer countByLastName(String lastName);
}
