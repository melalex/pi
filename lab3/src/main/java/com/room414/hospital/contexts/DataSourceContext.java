package com.room414.hospital.contexts;

import com.room414.hospital.dao.query.QueryTemplate;
import com.room414.hospital.dao.query.impl.QueryTemplateImpl;
import com.room414.hospital.exceptions.StartUpException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DataSourceContext {
    private static final String PROPERTIES_LOCATION = "datasource.properties";
    private static final String DRIVER_PROPERTY = "datasource.driver";
    private static final String HOST_PROPERTY = "datasource.host";
    private static final String USERNAME_PROPERTY = "datasource.user";
    private static final String PASSWORD_PROPERTY = "datasource.password";
    private static final String CONNECTION_COUNT_PROPERTY = "datasource.connection.maxCount";

    @Getter(lazy = true)
    private final QueryTemplate queryTemplate = new QueryTemplateImpl();

    @Getter(lazy = true)
    private final DataSource dataSource = loadDataSource();

    private DataSource loadDataSource() {
        Properties properties = loadDataSourceProperties();
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(properties.getProperty(DRIVER_PROPERTY));
        dataSource.setUrl(properties.getProperty(HOST_PROPERTY));
        dataSource.setUsername(properties.getProperty(USERNAME_PROPERTY));
        dataSource.setPassword(properties.getProperty(PASSWORD_PROPERTY));
        dataSource.setMaxTotal(Integer.parseInt(properties.getProperty(CONNECTION_COUNT_PROPERTY)));

        return dataSource;
    }

    private Properties loadDataSourceProperties() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(PROPERTIES_LOCATION)) {
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            String message = String.format("Exception during reading properties from file '%s'", PROPERTIES_LOCATION);
            log.error(message, e);
            throw new StartUpException(message, e);
        }
    }
}
