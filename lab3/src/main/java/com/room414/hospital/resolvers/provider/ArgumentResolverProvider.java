package com.room414.hospital.resolvers.provider;

import com.room414.hospital.resolvers.ArgumentResolver;

public interface ArgumentResolverProvider {

    <T> ArgumentResolver<T> provide(Class<T> clazz);
}
