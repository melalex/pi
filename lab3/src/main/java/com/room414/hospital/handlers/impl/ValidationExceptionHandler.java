package com.room414.hospital.handlers.impl;

import com.room414.hospital.anotations.Handler;
import com.room414.hospital.commands.iternal.Attributes;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.exceptions.ValidationException;
import com.room414.hospital.handlers.ExceptionHandler;
import com.room414.hospital.services.MessageService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.room414.hospital.utils.SessionUtil.locale;

@Slf4j
@Handler(ValidationException.class)
public class ValidationExceptionHandler implements ExceptionHandler<ValidationException> {
    private final MessageService messageService = ApplicationContext.getInstance().getMessageService();

    @Override
    public ExecutionResult handle(ValidationException exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(Attributes.ERROR, error(exception, request));

        return ExecutionResult.of(form(request), HttpServletResponse.SC_NOT_FOUND, ExecutionResult.Type.FORWARD);
    }

    private List<String> error(ValidationException exception, HttpServletRequest request) {
        return exception.getErrorCodes()
                .stream()
                .map(c -> messageService.message(c, locale(request)))
                .collect(Collectors.toList());
    }

    private String form(HttpServletRequest request) {
        return (String) request.getAttribute(Attributes.FORM_VIEW);
    }
}