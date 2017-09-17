package com.room414.hospital.handlers.provider.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.handlers.ExceptionHandler;
import com.room414.hospital.handlers.provider.ExceptionHandlerProvider;

import java.util.Map;

public class ExceptionHandlerProviderImpl implements ExceptionHandlerProvider {
    private Map<Class<? extends Throwable>, ExceptionHandler<? extends Throwable>> handlers = ApplicationContext.getInstance().getHandlers();
    private ExceptionHandler<Throwable> defaultExceptionHandler = ApplicationContext.getInstance().getDefaultExceptionHandler();

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Throwable> ExceptionHandler<T> provide(Class<? extends Throwable> clazz) {
        return (ExceptionHandler<T>) handlers.getOrDefault(clazz, defaultExceptionHandler);
    }
}
