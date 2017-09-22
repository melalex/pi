package com.room414.hospital.commands.doctor;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.DoctorService;
import com.room414.hospital.utils.ResolverUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route(method = HttpMethod.GET, path = Routes.DOCTOR)
public class GetDoctor extends AbstractCommand {
    private final DoctorService doctorService = ApplicationContext.getInstance().getDoctorService();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        return ExecutionResult.builder()
                .path(Views.DOCTOR)
                .model(doctorService.findByUsername(ResolverUtils.getStringId(request)))
                .statusCode(HttpServletResponse.SC_OK)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.DOCTOR;
    }
}