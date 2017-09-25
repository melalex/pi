package com.room414.hospital.services.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.converters.Converter;
import com.room414.hospital.dao.DutyDao;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Duty;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.services.DutyService;
import com.room414.hospital.utils.PaginationUtils;
import com.room414.hospital.validators.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DutyServiceImpl implements DutyService {
    private final DutyDao dutyDao = ApplicationContext.getInstance().getDutyDao();
    private final Validator<DutyForm> dutyFormValidator = ApplicationContext.getInstance().getDutyFormValidator();
    private final Converter<DutyForm, Duty> dutyConverter = ApplicationContext.getInstance().getDutyFormConverter();

    @Override
    public void create(DutyForm form) {
        dutyFormValidator.validate(form);
        dutyDao.create(dutyConverter.convert(form));
        log.info("Create new Duty {}", form);
    }

    @Override
    public Page<Duty> findByLastName(String lastName, Pageable pageable) {
        List<Duty> content = dutyDao.findByLastName(lastName, pageable);
        Pageable counted = PaginationUtils.withCount(pageable, dutyDao.countByLastName(lastName));

        return Page.of(content, counted);
    }
}
