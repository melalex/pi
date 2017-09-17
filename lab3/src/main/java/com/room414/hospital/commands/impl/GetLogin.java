package com.room414.hospital.commands.impl;

import com.room414.hospital.commands.iternal.ExecutionResult;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.routing.internal.Route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Route(method = HttpMethod.GET, path = "/login")
public class GetLogin extends AbstractCommand {

    @Override
    protected ExecutionResult doExecute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
