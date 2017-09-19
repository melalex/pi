package com.room414.hospital.handlers.impl;

import com.room414.hospital.anotations.Handler;
import com.room414.hospital.commands.iternal.Attributes;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.exceptions.ValidationException;
import com.room414.hospital.handlers.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Handler(ValidationException.class)
public class ValidationExceptionHandler implements ExceptionHandler<ValidationException> {

    @Override
    public ExecutionResult handle(ValidationException exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(Attributes.ERRORS, exception.getErrorCodes());

        return ExecutionResult.of(form(request), HttpServletResponse.SC_NOT_ACCEPTABLE, ExecutionResult.Type.FORWARD);
    }

    private String form(HttpServletRequest request) {
        return (String) request.getAttribute(Attributes.FORM_VIEW);
    }
}