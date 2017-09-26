package com.room414.hospital.commands.patient;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.PatientService;
import com.room414.hospital.utils.ResolverUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Route(method = HttpMethod.GET, path = Routes.PATIENT)
public class GetPatient extends AbstractCommand {
    private final PatientService patientService = ApplicationContext.getInstance().getPatientService();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) {
        return ExecutionResult.builder()
                .path(Views.PATIENT)
                .model(patientService.findById(ResolverUtils.getLongId(request)))
                .statusCode(HttpServletResponse.SC_OK)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.PATIENT;
    }
}
