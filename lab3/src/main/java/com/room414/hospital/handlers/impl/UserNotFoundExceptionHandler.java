package com.room414.hospital.handlers.impl;

import com.google.common.collect.ImmutableList;
import com.room414.hospital.anotations.Handler;
import com.room414.hospital.commands.iternal.Attributes;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.exceptions.UserNotFoundException;
import com.room414.hospital.handlers.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Handler(UserNotFoundException.class)
public class UserNotFoundExceptionHandler implements ExceptionHandler<UserNotFoundException> {
    private static final String USER_NOT_FOUND = "errors.user.notFound";

    @Override
    public ExecutionResult handle(UserNotFoundException exception, HttpServletRequest request) throws ServletException, IOException {
        log.debug("Can't find {} user", exception.getUsername());

        request.setAttribute(Attributes.ERRORS, ImmutableList.of(USER_NOT_FOUND));

        return ExecutionResult.builder()
                .path(Views.SIGN_IN)
                .statusCode(HttpServletResponse.SC_NOT_FOUND)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }
}