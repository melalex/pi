package com.room414.hospital;

import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.routing.Router;
import com.room414.hospital.routing.internal.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 2506454429968763561L;

    private Router router = ApplicationContext.getInstance().getRouter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(HttpMethod.GET, req.getRequestURI()).execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(HttpMethod.POST, req.getRequestURI()).execute(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(HttpMethod.PUT, req.getRequestURI()).execute(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(HttpMethod.DELETE, req.getRequestURI()).execute(req, resp);
    }
}