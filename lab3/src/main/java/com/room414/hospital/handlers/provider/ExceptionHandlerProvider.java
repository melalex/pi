package com.room414.hospital.handlers.provider;

import com.room414.hospital.handlers.ExceptionHandler;

public interface ExceptionHandlerProvider {

    <T extends Throwable> ExceptionHandler<T> provide(Class<? extends Throwable> clazz);
}
