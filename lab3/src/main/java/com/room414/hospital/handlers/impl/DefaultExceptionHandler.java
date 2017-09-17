package com.room414.hospital.handlers.impl;

import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.handlers.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class DefaultExceptionHandler implements ExceptionHandler<Throwable> {

    @Override
    public ExecutionResult handle(Throwable exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.error("Unexpected exception", exception);

        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return ExecutionResult.of("/error", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ExecutionResult.Type.ERROR);
    }
}
