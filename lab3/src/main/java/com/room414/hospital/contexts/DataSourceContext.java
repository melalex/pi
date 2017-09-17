package com.room414.hospital.contexts;

import com.room414.hospital.dao.mapping.providers.MappingProvider;
import com.room414.hospital.dao.query.QueryTemplate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.sql.DataSource;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DataSourceContext {
    private QueryTemplate queryTemplate;
    private DataSource dataSource;
    private MappingProvider mappingProvider;
}
