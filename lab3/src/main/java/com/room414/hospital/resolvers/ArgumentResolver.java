package com.room414.hospital.resolvers;

import javax.servlet.http.HttpServletRequest;

public interface ArgumentResolver<T> {

    T resolve(HttpServletRequest request);
}
