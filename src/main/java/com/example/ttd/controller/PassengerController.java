package com.example.ttd.controller;

import com.example.ttd.common.ResponseMessage;
import com.example.ttd.common.exception.CommonException;
import com.example.ttd.common.exception.ErrorCode;
import com.example.ttd.common.Helper.ControllerHelper;
import com.example.ttd.domain.dto.PassengerDTO;
import com.example.ttd.domain.service.PassengerService;

public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public ResponseMessage<String> enrollment(PassengerDTO passengerDTO) {
        if (!ControllerHelper.isValidPassenger(passengerDTO)) {
            throw new CommonException(ErrorCode.INVALID_INPUT);
        }
        passengerService.register(passengerDTO);
        return new ResponseMessage<>("회원 가입이 성공적으로 완료되었습니다.", 200, "가입 성공");
    }

    public ResponseMessage<String> checkIn(String userId, String userPw) {
        if (!ControllerHelper.isValidLogin(userId, userPw)) {
            throw new CommonException(ErrorCode.INVALID_INPUT);
        }
        passengerService.login(userId, userPw);
        return new ResponseMessage<>("로그인이 성공적으로 완료되었습니다.", 200, "로그인 성공");
    }

    public ResponseMessage<Double> addPoint(String userId, String userPw, double point) {
        if (!ControllerHelper.isValidLogin(userId, userPw) || point < 0) {
            throw new CommonException(ErrorCode.INVALID_INPUT);
        }
        double updatedPoints = passengerService.rechargePoint(userId, userPw, point);
        return new ResponseMessage<>("포인트가 성공적으로 추가되었습니다.", 200, updatedPoints);
    }

    public ResponseMessage<String> cancelEnrollment(String userId, String userPw) {
        if (!ControllerHelper.isValidLogin(userId, userPw)) {
            throw new CommonException(ErrorCode.INVALID_INPUT);
        }
        passengerService.unSubscribe(userId, userPw);
        return new ResponseMessage<>("회원 탈퇴가 성공적으로 완료되었습니다.", 200, "탈퇴 성공");
    }
}
