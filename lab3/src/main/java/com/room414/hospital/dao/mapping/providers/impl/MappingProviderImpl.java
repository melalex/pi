package com.room414.hospital.dao.mapping.providers.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.dao.mapping.RowMapper;
import com.room414.hospital.dao.mapping.providers.MappingProvider;
import com.room414.hospital.exceptions.MappingException;

import java.util.Map;
import java.util.Objects;

public class MappingProviderImpl implements MappingProvider {
    private Map<Class<?>, RowMapper<?>> mappers = ApplicationContext.getInstance().getMappers();

    @Override
    public <T> RowMapper<T> provide(Class<T> clazz) {
        RowMapper<T> rowMapper = cast(mappers.get(clazz));

        if (Objects.isNull(rowMapper)) {
            String message = String.format("No RowMapper registered for %s class", clazz);

            throw new MappingException(message);
        }

        return rowMapper;
    }

    @SuppressWarnings("unchecked")
    private <T> RowMapper<T> cast(RowMapper<?> rowMapper) {
        return (RowMapper<T>) rowMapper;
    }
}
