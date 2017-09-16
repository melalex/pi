package com.room414.hospital.converters;

@FunctionalInterface
public interface Converter<S, D> {

    D convert(S source);
}
