package com.room414.hospital.commands.patient;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route(method = HttpMethod.GET, path = Routes.PATIENTS_LIST)
public class GetPatientsList extends AbstractCommand{
    private final PatientService patientService = ApplicationContext.getInstance().getPatientService();
    private final ArgumentResolverProvider argumentResolverProvider = ApplicationContext.getInstance().getArgumentResolverProvider();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        Pageable pageable = argumentResolverProvider.provide(Pageable.class).resolve(request);

        return ExecutionResult.builder()
                .path(Views.PATIENTS_LIST)
                .model(patientService.findAll(pageable))
                .statusCode(HttpServletResponse.SC_OK)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.PATIENTS_LIST;
    }
}
