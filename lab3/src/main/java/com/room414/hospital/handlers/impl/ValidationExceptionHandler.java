package com.room414.hospital.handlers.impl;

import com.room414.hospital.anotations.Handler;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.exceptions.ValidationException;
import com.room414.hospital.handlers.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Handler(ValidationException.class)
public class ValidationExceptionHandler implements ExceptionHandler<ValidationException> {

    @Override
    public ExecutionResult handle(ValidationException exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
