package com.room414.hospital.commands.duty;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.domain.Pageable;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.DutyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route(method = HttpMethod.GET, path = Routes.DUTIES_LIST)
public class GetDutiesList extends AbstractCommand {
    private static final String LAST_NAME_PARAM = "lastName";

    private final DutyService dutyService = ApplicationContext.getInstance().getDutyService();
    private final ArgumentResolverProvider argumentResolverProvider = ApplicationContext.getInstance().getArgumentResolverProvider();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        Pageable pageable = argumentResolverProvider.provide(Pageable.class).resolve(request);
        String lastName = request.getParameter(LAST_NAME_PARAM);

        return ExecutionResult.builder()
                .path(Views.DOCTORS_LIST)
                .model(dutyService.findByLastName(lastName, pageable))
                .statusCode(HttpServletResponse.SC_OK)
                .type(ExecutionResult.Type.FORWARD)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.DUTIES_LIST;
    }
}
