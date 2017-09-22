package com.room414.hospital.commands.doctor;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.domain.internal.DoctorCriteria;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route(method = HttpMethod.GET, path = Routes.DOCTORS_LIST)
public class GetDoctorsList extends AbstractCommand {
    private final DoctorService doctorService = ApplicationContext.getInstance().getDoctorService();
    private final ArgumentResolverProvider resolverProvider = ApplicationContext.getInstance().getArgumentResolverProvider();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        DoctorCriteria criteria = resolverProvider.provide(DoctorCriteria.class).resolve(request);
        Pageable pageable = resolverProvider.provide(Pageable.class).resolve(request);

        return ExecutionResult.builder()
                .path(Views.DOCTORS_LIST)
                .model(doctorService.findByCriteria(criteria, pageable))
                .statusCode(HttpServletResponse.SC_OK)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.DOCTORS_LIST;
    }
}
