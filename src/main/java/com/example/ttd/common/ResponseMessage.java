package com.example.ttd.common;

import com.example.ttd.common.exception.ErrorCode;

public class ResponseMessage<T> {
    private String msg;
    private int statusCode;
    private T data;

    public ResponseMessage(String msg, int statusCode, T data) {
        this.msg = msg;
        this.statusCode = statusCode;
        this.data = data;
    }

    public ResponseMessage(ErrorCode errorCode, T data) {
        this.msg = errorCode.getDescription();
        this.statusCode = errorCode.getCode();
        this.data = data;
    }

    public ResponseMessage(ErrorCode errorCode) {
        this.msg = errorCode.getDescription();
        this.statusCode = errorCode.getCode();
    }

    public String getMsg() {
        return msg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getData() {
        return data;
    }
}
