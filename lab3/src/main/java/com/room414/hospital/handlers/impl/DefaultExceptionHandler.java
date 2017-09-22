package com.room414.hospital.handlers.impl;

import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.handlers.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class DefaultExceptionHandler implements ExceptionHandler<Throwable> {

    @Override
    public ExecutionResult handle(Throwable exception, HttpServletRequest request) throws ServletException, IOException {
        log.error("Unexpected exception", exception);

        return ExecutionResult.builder()
                .path(Views.ERROR)
                .statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .type(ExecutionResult.Type.ERROR)
                .build();
    }
}
