package com.room414.hospital.handlers.impl;

import com.google.common.collect.ImmutableList;
import com.room414.hospital.anotations.Handler;
import com.room414.hospital.commands.iternal.Attributes;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.exceptions.UserNotFoundException;
import com.room414.hospital.handlers.ExceptionHandler;
import com.room414.hospital.services.MessageService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.room414.hospital.utils.SessionUtil.locale;

@Slf4j
@Handler(UserNotFoundException.class)
public class UserNotFoundExceptionHandler implements ExceptionHandler<UserNotFoundException> {
    private static final String USER_NOT_FOUND = "errors.user.notFound";

    private final MessageService messageService = ApplicationContext.getInstance().getMessageService();

    @Override
    public ExecutionResult handle(UserNotFoundException exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Can't find {} user", exception.getUsername());

        request.setAttribute(Attributes.ERROR, error(request));

        return ExecutionResult.of(Views.LOGIN, HttpServletResponse.SC_NOT_FOUND, ExecutionResult.Type.FORWARD);
    }

    private List<String> error(HttpServletRequest request) {
        return ImmutableList.of(messageService.message(USER_NOT_FOUND, locale(request)));
    }
}