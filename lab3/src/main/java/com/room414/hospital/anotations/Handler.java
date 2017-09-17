package com.room414.hospital.anotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Handler {

    Class<? extends Throwable> value();
}
