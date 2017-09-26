package com.room414.hospital.contexts;

import com.google.common.collect.ImmutableMap;
import com.room414.hospital.dao.mapping.RowMapper;
import com.room414.hospital.dao.mapping.impl.ApplicationUserMapper;
import com.room414.hospital.dao.mapping.impl.DoctorMapper;
import com.room414.hospital.dao.mapping.impl.DutyMapper;
import com.room414.hospital.dao.mapping.impl.PatientMapper;
import com.room414.hospital.dao.mapping.providers.MappingProvider;
import com.room414.hospital.dao.mapping.providers.impl.MappingProviderImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class MappingContext {

    @Getter(lazy = true)
    private final MappingProvider mappingProvider = new MappingProviderImpl();

    @Getter(lazy = true)
    private final Map<Class<?>, RowMapper<?>> mappers = loadMappers();

    private Map<Class<?>, RowMapper<?>> loadMappers() {
        ApplicationUserMapper applicationUserMapper = new ApplicationUserMapper();
        DoctorMapper doctorMapper = new DoctorMapper(applicationUserMapper);
        DutyMapper dutyMapper = new DutyMapper(doctorMapper);
        PatientMapper patientMapper = new PatientMapper(doctorMapper);

        return ImmutableMap.<Class<?>, RowMapper<?>>builder()
                .put(applicationUserMapper.support(), applicationUserMapper)
                .put(doctorMapper.support(), doctorMapper)
                .put(dutyMapper.support(), dutyMapper)
                .put(patientMapper.support(), patientMapper)
                .build();
    }
}
