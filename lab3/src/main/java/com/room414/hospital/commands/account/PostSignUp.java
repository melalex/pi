package com.room414.hospital.commands.account;

import com.room414.hospital.anotations.Route;
import com.room414.hospital.commands.iternal.AbstractCommand;
import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.routing.internal.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Route(method = HttpMethod.POST, path = "/join")
public class PostSignUp extends AbstractCommand {

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
