package com.room414.hospital.routing.impl;

import com.room414.hospital.commands.Command;
import com.room414.hospital.contexts.ApplicationContext;
import com.room414.hospital.routing.Router;
import com.room414.hospital.routing.internal.HttpMethod;
import com.room414.hospital.routing.internal.RouteValue;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class RouterImpl implements Router {
    private final Map<RouteValue, Command> routes = ApplicationContext.getInstance().getRoutes();
    private final Command notFound = ApplicationContext.getInstance().getDefaultCommand();

    @Override
    public Command route(HttpMethod method, String path) {
        log.debug("Request for {}:{}", method, path);

        return routes.getOrDefault(RouteValue.of(method, path), notFound);
    }

    @Override
    public void redirect(String to, HttpServletResponse response) throws IOException {
        log.debug("Redirect to {}", to);

        response.sendRedirect(to);
    }
}
