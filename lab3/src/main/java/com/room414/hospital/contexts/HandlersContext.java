package com.room414.hospital.contexts;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.room414.hospital.anotations.Handler;
import com.room414.hospital.exceptions.StartUpException;
import com.room414.hospital.handlers.ExceptionHandler;
import com.room414.hospital.handlers.impl.DefaultExceptionHandler;
import com.room414.hospital.handlers.provider.ExceptionHandlerProvider;
import com.room414.hospital.handlers.provider.impl.ExceptionHandlerProviderImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class HandlersContext {
    private final static String HANDLERS_PACKAGE = "com.room414.hospital.handlers.impl";

    @Getter(lazy = true)
    private final ExceptionHandlerProvider exceptionHandlerProvider = new ExceptionHandlerProviderImpl();

    @Getter(lazy = true)
    private final ExceptionHandler<Throwable> defaultExceptionHandler = new DefaultExceptionHandler();

    @Getter(lazy = true)
    private final Map<Class<? extends Throwable>, ExceptionHandler<? extends Throwable>> handlers = loadHandlers();

    private Map<Class<? extends Throwable>, ExceptionHandler<? extends Throwable>> loadHandlers() {
        Reflections reflections = new Reflections(HANDLERS_PACKAGE);
        Set<Class<?>> handlerClasses = reflections.getTypesAnnotatedWith(Handler.class);
        Map<Class<? extends Throwable>, ExceptionHandler<? extends Throwable>> result = Maps.newHashMap();

        for (Class<?> handlerClass : handlerClasses) {
            Handler annotation = handlerClass.getAnnotation(Handler.class);
            ExceptionHandler<? extends Throwable> handler = byClass(handlerClass);
            result.put(annotation.value(), handler);
        }

        return ImmutableMap.copyOf(result);
    }

    private ExceptionHandler<? extends Throwable> byClass(Class<?> clazz) {
        try {
            Object object = clazz.getConstructor().newInstance();

            if (object instanceof ExceptionHandler) {
                return (ExceptionHandler<? extends Throwable>) object;
            }

            throw new StartUpException("Only classes that extends %s can have %s annotation", ExceptionHandler.class, Handler.class);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new StartUpException("ExceptionHandler creation failed", e);
        }
    }
}
