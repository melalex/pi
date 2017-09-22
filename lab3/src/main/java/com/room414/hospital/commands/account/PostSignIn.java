package com.room414.hospital.commands.account;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.domain.entities.Doctor;
import com.room414.hospital.exceptions.UserNotFoundException;
import com.room414.hospital.forms.AuthenticationForm;
import com.room414.hospital.resolvers.provider.ArgumentResolverProvider;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.services.DoctorService;
import com.room414.hospital.services.UserService;
import com.room414.hospital.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Route(method = HttpMethod.POST, path = Routes.SIGN_IN)
public class PostSignIn extends AbstractCommand {
    private ArgumentResolverProvider resolverProvider = ApplicationContext.getInstance().getArgumentResolverProvider();
    private UserService userService = ApplicationContext.getInstance().getUserService();
    private DoctorService doctorService = ApplicationContext.getInstance().getDoctorService();

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        AuthenticationForm form = resolverProvider.provide(AuthenticationForm.class)
                .resolve(request);

        if (userService.tryAuthenticate(form)) {
            throw new UserNotFoundException(form.getUsername());
        }

        Doctor doctor = doctorService.findByUsername(form.getUsername());

        SessionUtil.saveUser(request, doctor);

        return ExecutionResult.redirectTo(Routes.HOME);
    }

    @Override
    protected String rollbackView() {
        return Views.SIGN_IN;
    }
}