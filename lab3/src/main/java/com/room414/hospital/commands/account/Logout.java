package com.room414.hospital.commands.account;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.commands.iternal.Routes;
import com.room414.hospital.commands.iternal.Views;
import com.room414.hospital.routing.internal.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Route(method = HttpMethod.GET, path = Routes.LOGOUT)
public class Logout extends AbstractCommand {

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request) throws ServletException, IOException {
        request.getSession().invalidate();

        return ExecutionResult.redirectTo(Routes.HOME);
    }

    @Override
    protected String rollbackView() {
        return Views.HOME;
    }
}
