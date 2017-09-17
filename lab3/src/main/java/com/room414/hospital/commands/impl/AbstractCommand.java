package com.room414.hospital.commands.impl;

import com.room414.hospital.commands.Command;
import com.room414.hospital.commands.iternal.ExecutionResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ExecutionResult executionResult = doExecute(request, response);
        } catch (Throwable t) {

        }
    }

    protected abstract ExecutionResult doExecute(HttpServletRequest request, HttpServletResponse response);
}
