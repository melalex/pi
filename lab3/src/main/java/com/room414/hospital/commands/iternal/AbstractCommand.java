package com.room414.hospital.commands.iternal;

import com.room414.hospital.commands.Command;
import com.room414.hospital.handlers.provider.ExceptionHandlerProvider;
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
            request.setAttribute(Attributes.FORM_VIEW, currentView());

            executionResult = doExecute(request, response);
        } catch (Throwable throwable) {
            executionResult = exceptionHandlerProvider.provide(throwable.getClass())
                    .handle(throwable, request, response);
        }

        response.setStatus(executionResult.getStatusCode());

        if (ExecutionResult.Type.FORWARD.equals(executionResult.getType())) {
            request.getRequestDispatcher(executionResult.getPath())
                    .forward(request, response);
        } else if (ExecutionResult.Type.REDIRECT.equals(executionResult.getType())) {
            response.sendRedirect(executionResult.getPath());
        } else if (ExecutionResult.Type.ERROR.equals(executionResult.getType())) {
            response.sendError(executionResult.getStatusCode());
        }
    }

    private String currentView() {
        return Views.HOME;
    }

    protected abstract ExecutionResult doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
