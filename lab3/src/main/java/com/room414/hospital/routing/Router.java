package com.room414.hospital.routing;

import com.room414.hospital.commands.Command;
import com.room414.hospital.routing.internal.HttpMethod;

public interface Router {

    Command route(HttpMethod method, String path);

    default Command route(String path) {
        return route(HttpMethod.GET, path);
    }
}
