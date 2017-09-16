package com.room414.hospital.services.impl;

import com.room414.hospital.converters.Converter;
import com.room414.hospital.dao.DutyDao;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.entities.Duty;
import com.room414.hospital.domain.internal.Page;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.services.DutyService;
import com.room414.hospital.validators.Validator;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.room414.hospital.utils.PaginationUtils.withCount;

@AllArgsConstructor
public class DutyServiceImpl implements DutyService {
    private DutyDao dutyDao;
    private Validator<DutyForm> dutyFormValidator;
    private Converter<DutyForm, Duty> dutyConverter;

    @Override
    public void create(DutyForm duty) {
        dutyFormValidator.validate(duty);
        dutyDao.create(dutyConverter.convert(duty));
    }

    @Override
    public Page<Duty> findByLastName(String lastName, Pageable pageable) {
        List<Duty> content = dutyDao.findByLastName(lastName, pageable);
        Pageable counted = withCount(pageable, dutyDao.countByLastName(lastName));

        return Page.of(content, counted);
    }
}
