package com.room414.hospital.routing.internal;

import lombok.Value;

@Value(staticConstructor = "of")
public class RouteValue {
    private HttpMethod method;
    private String path;
}
