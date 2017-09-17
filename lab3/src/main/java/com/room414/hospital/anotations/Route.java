package com.room414.hospital.anotations;

import com.room414.hospital.routing.internal.HttpMethod;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Route {

    HttpMethod method() default HttpMethod.GET;

    String path();
}
