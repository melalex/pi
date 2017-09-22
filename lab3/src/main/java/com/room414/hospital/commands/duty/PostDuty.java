package com.room414.hospital.commands.duty;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.forms.DutyForm;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.DutyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route(method = HttpMethod.POST, path = Routes.CREATE_DUTY)
public class PostDuty extends AbstractCommand {
    private final DutyService dutyService = ApplicationContext.getInstance().getDutyService();
    private final ArgumentResolverProvider argumentResolverProvider = ApplicationContext.getInstance().getArgumentResolverProvider();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        DutyForm form = argumentResolverProvider.provide(DutyForm.class).resolve(request);

        dutyService.create(form);

        return ExecutionResult.builder()
                .path(Routes.DUTIES_LIST)
                .statusCode(HttpServletResponse.SC_CREATED)
                .type(ExecutionResult.Type.REDIRECT)
                .build();
    }

    @Override
    protected String rollbackView() {
        return Views.DUTY;
    }
}