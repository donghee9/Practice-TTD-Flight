package com.example.ttd.common.exception;
public enum SuccessCode {
    OK(200, "정상 입니다.");

    private final int code;
    private final String description;

    SuccessCode(int code, String description) {
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

