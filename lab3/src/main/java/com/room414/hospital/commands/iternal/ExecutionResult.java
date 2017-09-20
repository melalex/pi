package com.room414.hospital.commands.iternal;

import lombok.Builder;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@Builder
public class ExecutionResult {
    private String path;
    private Object model;
    private int statusCode;
    private Type type;

    public enum Type {
        REDIRECT,
        FORWARD,
        ERROR
    }

    public static ExecutionResult redirectTo(String path) {
        return ExecutionResult.builder()
                .path(path)
                .statusCode(HttpServletResponse.SC_OK)
                .type(Type.REDIRECT)
                .build();
    }
}
