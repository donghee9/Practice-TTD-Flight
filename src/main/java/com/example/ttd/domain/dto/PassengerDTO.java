package com.example.ttd.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerDTO {
    private int id;
    private String name;
    private String userLoginId;
    private String email;
    private String phone;
    private String pw;
    private double point;

    private PassengerDTO() {
    }

    public static PassengerDTO of(String name, String userLoginId, String email, String phone, String pw, double initialPoint) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.id = IdGenerator.getNextPassengerId();
        passengerDTO.name = name;
        passengerDTO.userLoginId = userLoginId;
        passengerDTO.email = email;
        passengerDTO.phone = phone;
        passengerDTO.pw = pw;
        passengerDTO.point = initialPoint;
        return passengerDTO;
    }
}

