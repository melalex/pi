package com.room414.hospital.commands.iternal;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.exceptions.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DefaultCommand extends AbstractCommand {
    private Map<String, String> jspRoutes = ApplicationContext.getInstance().getJspRoutes();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = jspRoutes.get(request.getRequestURI());

        if (jsp == null) {
            throw new NotFoundException("Wrong Url: {}", request.getRequestURI());
        }

        return ExecutionResult.of(jsp, HttpServletResponse.SC_OK, ExecutionResult.Type.FORWARD);
    }
}
