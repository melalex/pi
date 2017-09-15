package com.room414.hospital.dao.mapping.providers.impl;

import com.room414.hospital.dao.mapping.RowMapper;
import com.room414.hospital.dao.mapping.providers.MappingProvider;

import java.util.Map;

public class MappingProviderImpl implements MappingProvider {

    @Override
    public <T> RowMapper<T> provide(Class<T> clazz) {
        return null;
    }
}
