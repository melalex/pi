package com.room414.hospital.commands.iternal;

import com.room414.hospital.commands.Command;
import com.room414.hospital.handlers.provider.ExceptionHandlerProvider;
import com.room414.hospital.contexts.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommand implements Command {
    private final ExceptionHandlerProvider exceptionHandlerProvider = ApplicationContext.getInstance()
            .getExceptionHandlerProvider();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExecutionResult executionResult;

        try {
            request.setAttribute(Attributes.PREVIOUS_VIEW, rollbackView());

            executionResult = doExecute(request);
        } catch (Throwable throwable) {
            executionResult = exceptionHandlerProvider.provide(throwable.getClass())
                    .handle(throwable, request);
        }

        response.setStatus(executionResult.getStatusCode());

        if (ExecutionResult.Type.FORWARD.equals(executionResult.getType())) {
            request.setAttribute(Attributes.MODEL, executionResult.getModel());
            request.getRequestDispatcher(executionResult.getPath())
                    .forward(request, response);
        } else if (ExecutionResult.Type.REDIRECT.equals(executionResult.getType())) {
            response.sendRedirect(executionResult.getPath());
        } else if (ExecutionResult.Type.ERROR.equals(executionResult.getType())) {
            response.sendError(executionResult.getStatusCode());
        }
    }

    protected abstract ExecutionResult doExecute(HttpServletRequest request);

    protected abstract String rollbackView();
}
