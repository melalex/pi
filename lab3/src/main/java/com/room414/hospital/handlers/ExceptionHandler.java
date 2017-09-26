package com.room414.hospital.handlers;

import com.room414.hospital.commands.iternal.ExecutionResult;

import javax.servlet.http.HttpServletRequest;

public interface ExceptionHandler<T extends Throwable> {

    ExecutionResult handle(T exception, HttpServletRequest request);
}
