package com.room414.hospital.handlers.impl;

import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.handlers.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class DefaultExceptionHandler implements ExceptionHandler<Throwable> {

    @Override
    public ExecutionResult handle(Throwable exception, HttpServletRequest request) {
        log.error("Unexpected exception", exception);

        return ExecutionResult.builder()
                .statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .type(ExecutionResult.Type.ERROR)
                .build();
    }
}
