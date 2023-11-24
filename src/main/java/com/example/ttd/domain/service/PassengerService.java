package com.example.ttd.domain.service;
import com.example.ttd.common.exception.UserNotFoundException;
import com.example.ttd.domain.dto.PassengerDTO;

public interface PassengerService {
    void register(PassengerDTO passengerDTO);
    void login(String userId ,String userPw) throws UserNotFoundException;
    double rechargePoint(String userId , String userPw , double point) throws  UserNotFoundException;
    void unSubscribe(String userId ,String userPw) throws  UserNotFoundException;
}
