package com.room414.hospital.contexts;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.room414.hospital.anotations.Resolver;
import com.room414.hospital.exceptions.StartUpException;
import com.room414.hospital.resolvers.ArgumentResolver;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;
import com.room414.hospital.resolvers.provider.impl.ArgumentResolverProviderImpl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
class ResolversContext {
    private final static String RESOLVERS_PACKAGE = "com.room414.hospital.resolvers.impl";

    @Getter(lazy = true)
    private final ArgumentResolverProvider argumentResolverProvider = new ArgumentResolverProviderImpl();

    @Getter(lazy = true)
    private final Map<Class<?>, ArgumentResolver<?>> resolvers = loadResolvers();

    private Map<Class<?>, ArgumentResolver<?>> loadResolvers() {
        Reflections reflections = new Reflections(RESOLVERS_PACKAGE);
        Set<Class<?>> resolverClasses = reflections.getTypesAnnotatedWith(Resolver.class);
        Map<Class<?>, ArgumentResolver<?>> result = Maps.newHashMap();

        for (Class<?> resolverClass : resolverClasses) {
            Resolver annotation = resolverClass.getAnnotation(Resolver.class);
            ArgumentResolver<?> resolver = byClass(resolverClass);
            result.put(annotation.value(), resolver);
        }

        return ImmutableMap.copyOf(result);
    }

    private ArgumentResolver<?> byClass(Class<?> clazz) {
        try {
            Object object = clazz.getConstructor().newInstance();

            if (object instanceof ArgumentResolver) {
                return (ArgumentResolver<?>) object;
            }

            throw new StartUpException("Only classes that extends %s can have %s annotation", ArgumentResolver.class, Resolver.class);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new StartUpException("ArgumentResolver creation failed", e);
        }
    }

}
