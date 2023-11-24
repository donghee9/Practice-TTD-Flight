package com.example.ttd.common.exception;

import com.example.ttd.common.exception.CommonException;
import com.example.ttd.common.exception.ErrorCode;

public class UserNotFoundException extends CommonException {


    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }



}
