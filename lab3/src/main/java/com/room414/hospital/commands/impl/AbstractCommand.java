package com.room414.hospital.commands.impl;

import com.room414.hospital.commands.Command;
import com.room414.hospital.handlers.provider.ExceptionHandlerProvider;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.contexts.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommand implements Command {
    private ExceptionHandlerProvider exceptionHandlerProvider = ApplicationContext.getInstance()
            .getExceptionHandlerProvider();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExecutionResult executionResult;

        try {
            executionResult = doExecute(request, response);
        } catch (Throwable throwable) {
            executionResult = exceptionHandlerProvider.provide(throwable.getClass())
                    .handle(throwable, request, response);
        }

        response.setStatus(executionResult.getStatusCode());

        if (ExecutionResult.Type.FORWARD.equals(executionResult.getType())) {
            request.getRequestDispatcher(executionResult.getPath())
                    .forward(request, response);
        }
    }

    protected abstract ExecutionResult doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
