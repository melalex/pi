package com.room414.hospital.resolvers.impl;

import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.domain.entities.Secession;
import com.room414.hospital.domain.internal.DoctorCriteria;
import com.room414.hospital.resolvers.ArgumentResolver;
import com.room414.hospital.utils.ResolverUtils;

import javax.servlet.http.HttpServletRequest;

@Resolver(DoctorCriteria.class)
public class DoctorCriteriaResolver implements ArgumentResolver<DoctorCriteria> {
    private static final String DATE_PARAM = "date";
    private static final String SECESSION_PARAM = "secession";

    @Override
    public DoctorCriteria resolve(HttpServletRequest request) {
        DoctorCriteria doctorCriteria = new DoctorCriteria();

        doctorCriteria.setDutyDate(ResolverUtils.parseDate(request.getParameter(DATE_PARAM)));
        doctorCriteria.setSecession(Secession.of(request.getParameter(SECESSION_PARAM)));

        return doctorCriteria;
    }
}