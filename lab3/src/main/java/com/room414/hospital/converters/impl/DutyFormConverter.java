package com.room414.hospital.converters.impl;

import com.room414.hospital.converters.Converter;
import com.room414.hospital.domain.entities.Duty;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.utils.ConversionUtil;

public class DutyFormConverter implements Converter<DutyForm, Duty> {

    @Override
    public Duty convert(DutyForm source) {
        Duty duty = new Duty();

        duty.setDoctor(ConversionUtil.toDoctor(source.getDoctor()));
        duty.setDate(source.getDate());

        return null;
    }
}
