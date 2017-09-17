package com.room414.hospital.handlers;

import com.room414.hospital.commands.iternal.ExecutionResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExceptionHandler<T extends Throwable> {

    ExecutionResult handle(T exception, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
