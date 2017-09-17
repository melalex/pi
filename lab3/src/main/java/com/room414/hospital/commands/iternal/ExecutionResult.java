package com.room414.hospital.commands.iternal;

import lombok.Value;

@Value
public class ExecutionResult {
    private String path;
    private int statusCode;
    private Type type;

    private enum Type {
        REDIRECT,
        FORWARD
    }
}
