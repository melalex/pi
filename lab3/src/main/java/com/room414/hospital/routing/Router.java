package com.room414.hospital.routing;

import com.room414.hospital.commands.Command;
import com.room414.hospital.routing.internal.HttpMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Router {
    String DISPATCHER_SERVLET_MAPPING = "/site";

    Command route(HttpMethod method, String path);

    default Command route(String path) {
        return route(HttpMethod.GET, path);
    }

    void redirect(String to, HttpServletResponse response) throws IOException;
}
