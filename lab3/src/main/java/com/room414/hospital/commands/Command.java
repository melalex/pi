package com.room414.hospital.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FunctionalInterface
public interface Command {

    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
