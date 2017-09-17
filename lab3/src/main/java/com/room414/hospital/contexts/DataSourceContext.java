package com.room414.hospital.contexts;

import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.dao.query.impl.QueryTemplateImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.sql.DataSource;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DataSourceContext {

    @Getter(lazy = true)
    private final QueryTemplate queryTemplate = new QueryTemplateImpl();

    @Getter(lazy = true)
    private final DataSource dataSource = loadDataSource();

    private DataSource loadDataSource() {
        return null;
    }
}
