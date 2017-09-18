package com.room414.hospital.resolvers.provider.impl;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.exceptions.ResolveException;
import com.room414.hospital.resolvers.ArgumentResolver;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;

import java.util.Map;
import java.util.Objects;

public class ArgumentResolverProviderImpl implements ArgumentResolverProvider {
    private final Map<Class<?>, ArgumentResolver<?>> resolvers = ApplicationContext.getInstance().getResolvers();

    @Override
    public <T> ArgumentResolver<T> provide(Class<T> clazz) {
        ArgumentResolver<T> argumentResolver = cast(resolvers.get(clazz));

        if (Objects.isNull(argumentResolver)) {
            String message = String.format("No ArgumentResolver registered for %s class", clazz);

            throw new ResolveException(message);
        }

        return argumentResolver;
    }

    @SuppressWarnings("unchecked")
    private <T> ArgumentResolver<T> cast(ArgumentResolver<?> argumentResolver) {
        return (ArgumentResolver<T>) argumentResolver;
    }
}
