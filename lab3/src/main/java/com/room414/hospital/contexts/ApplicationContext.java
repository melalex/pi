package com.room414.hospital.contexts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationContext {
    private static ApplicationContext ourInstance = new ApplicationContext();

    @Delegate
    private final DataSourceContext dataSourceContext = new DataSourceContext();

    @Delegate
    private final MappingContext mappingContext = new MappingContext();

    @Delegate
    private final DataAccessContext dataAccessContext = new DataAccessContext();

    @Delegate
    private final ValidationContext validationContext = new ValidationContext();

    @Delegate
    private final ConversionContext conversionContext = new ConversionContext();

    @Delegate
    private final ServicesContext servicesContext = new ServicesContext();

    @Delegate
    private final RoutingContext routingContext = new RoutingContext();

    @Delegate
    private final HandlersContext handlersContext = new HandlersContext();

    public static ApplicationContext getInstance() {
        return ourInstance;
    }
}
