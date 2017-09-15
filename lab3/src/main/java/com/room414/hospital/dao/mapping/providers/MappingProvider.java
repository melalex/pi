package com.room414.hospital.dao.mapping.providers;

import com.room414.hospital.dao.mapping.RowMapper;

public interface MappingProvider {

    <T> RowMapper<T> provide(Class<T> clazz);
}
