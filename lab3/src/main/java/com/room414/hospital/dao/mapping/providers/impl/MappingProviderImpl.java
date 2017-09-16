package com.room414.hospital.dao.mapping.providers.impl;

import com.room414.hospital.dao.jdbc.exceptions.JdbcException;
import com.room414.hospital.dao.mapping.RowMapper;
import com.room414.hospital.dao.mapping.impl.ApplicationUserMapper;
import com.room414.hospital.dao.mapping.impl.DoctorMapper;
import com.room414.hospital.dao.mapping.impl.DutyMapper;
import com.room414.hospital.dao.mapping.impl.PatientMapper;
import com.room414.hospital.dao.mapping.providers.MappingProvider;

import java.util.Map;

public class MappingProviderImpl implements MappingProvider {

    private final ApplicationUserMapper userMapper = new ApplicationUserMapper();
    private final DoctorMapper doctorMapper = new DoctorMapper(userMapper);
    private final DutyMapper dutyMapper = new DutyMapper(doctorMapper);
    private final PatientMapper patientMapper = new PatientMapper(doctorMapper);

    @Override
    public <T> RowMapper<T> provide(Class<T> clazz) {
        if (userMapper.supportsClass(clazz)) {
            return cast(userMapper);
        } else if (doctorMapper.supportsClass(clazz)) {
            return cast(doctorMapper);
        } else if (dutyMapper.supportsClass(clazz)) {
            return cast(dutyMapper);
        } else if (patientMapper.supportsClass(clazz)) {
            return cast(patientMapper);
        } else {
            String message = String.format("No RowMapper registered for %s class", clazz);

            throw new JdbcException(message);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> RowMapper<T> cast(RowMapper<?> rowMapper) {
        return (RowMapper<T>) rowMapper;
    }
}
