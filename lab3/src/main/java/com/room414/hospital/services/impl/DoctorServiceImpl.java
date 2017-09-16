package com.room414.hospital.services.impl;

import com.room414.hospital.converters.Converter;
import com.room414.hospital.dao.DoctorDao;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.internal.DoctorCriteria;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.exceptions.NotFoundException;
import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.services.DoctorService;
import com.room414.hospital.utils.ErrorUtils;
import com.room414.hospital.validators.Validator;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.room414.hospital.utils.PaginationUtils.withCount;

@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorDao doctorDao;
    private Validator<AccountForm> accountFormValidator;
    private Converter<AccountForm, Doctor> doctorConverter;

    @Override
    public void create(AccountForm form) {
        accountFormValidator.validate(form);
        doctorDao.create(doctorConverter.convert(form));
    }

    @Override
    public boolean isDoctorExists(String username) {
        return doctorDao
                .findOne(username)
                .isPresent();
    }

    @Override
    public Doctor findByUsername(String username) {
        return doctorDao
                .findOne(username)
                .orElseThrow(ErrorUtils.notFound("Doctor", "username", username));
    }

    @Override
    public Page<Doctor> findByCriteria(DoctorCriteria criteria, Pageable pageable) {
        List<Doctor> content = doctorDao.findByCriteria(criteria, pageable);
        Pageable counted = withCount(pageable, doctorDao.countByCriteria(criteria));

        return Page.of(content, counted);
    }
}