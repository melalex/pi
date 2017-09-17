package com.room414.hospital.commands.iternal;

import lombok.Value;

@Value(staticConstructor = "of")
public class ExecutionResult {
    private String path;
    private int statusCode;
    private Type type;

    public enum Type {
        REDIRECT,
        FORWARD,
        ERROR
    }
}
