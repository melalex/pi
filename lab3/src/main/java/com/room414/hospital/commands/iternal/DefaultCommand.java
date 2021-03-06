package com.room414.hospital.commands.iternal;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.exceptions.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DefaultCommand extends AbstractCommand {
    private final Map<String, String> jspRoutes = ApplicationContext.getInstance().getJspRoutes();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) {
        String jsp = jspRoutes.get(request.getRequestURI());

        if (jsp == null) {
            throw new NotFoundException("Wrong Url: {}", request.getRequestURI());
        }

        return ExecutionResult.builder()
                .path(jsp)
                .statusCode(HttpServletResponse.SC_OK)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.HOME;
    }
}