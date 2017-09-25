package com.room414.hospital.services.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.converters.Converter;
import com.room414.hospital.dao.DoctorDao;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.domain.internal.DoctorCriteria;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.AccountForm;
import com.room414.hospital.services.DoctorService;
import com.room414.hospital.utils.ErrorUtils;
import com.room414.hospital.utils.PaginationUtils;
import com.room414.hospital.validators.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DoctorServiceImpl implements DoctorService {
    private final DoctorDao doctorDao = ApplicationContext.getInstance().getDoctorDao();
    private final Validator<AccountForm> accountFormValidator = ApplicationContext.getInstance().getAccountFormValidator();
    private final Converter<AccountForm, Doctor> doctorConverter = ApplicationContext.getInstance().getAccountFormConverter();

    @Override
    public void create(AccountForm form) {
        accountFormValidator.validate(form);
        doctorDao.create(doctorConverter.convert(form));
        log.info("Create new Account {}", form);
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
        Pageable counted = PaginationUtils.withCount(pageable, doctorDao.countByCriteria(criteria));

        return Page.of(content, counted);
    }
}