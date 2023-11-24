package com.example.ttd.common.exception;


public enum ErrorCode {
    USER_NOT_FOUND(100, "User not found"),
    INVALID_INPUT(101, "Invalid input provided"),
    DATABASE_ERROR(102, "Database error occurred"),
    SIGNUP_ERROR(103, "Signup Error occurred"),
    AUTH_ERROR(104, "auth Error occurred");

    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
