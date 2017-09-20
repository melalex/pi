package com.room414.hospital.handlers.impl;

import com.room414.hospital.anotations.Handler;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.exceptions.NotFoundException;
import com.room414.hospital.handlers.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Handler(NotFoundException.class)
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException> {

    @Override
    public ExecutionResult handle(NotFoundException exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.error("Not Found", exception);

        return ExecutionResult.builder()
                .statusCode(HttpServletResponse.SC_NOT_FOUND)
                .type(ExecutionResult.Type.ERROR)
                .build();
    }
}
