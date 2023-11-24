package com.example.ttd.common.Helper;

import com.example.ttd.domain.dto.PassengerDTO;


public class ControllerHelper {
    public static boolean isValidPassenger(PassengerDTO passengerDTO) {
        if (passengerDTO == null) {
            return false;
        }

        if (passengerDTO.getName() == null || passengerDTO.getName().trim().isEmpty()) {
            return false;
        }

        if (passengerDTO.getUserLoginId() == null || passengerDTO.getUserLoginId().trim().isEmpty()) {
            return false;
        }

        if (passengerDTO.getEmail() == null || !passengerDTO.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return false;
        }

        if (passengerDTO.getPhone() == null || !passengerDTO.getPhone().matches("^\\d{10}$")) {
            return false;
        }

        if (passengerDTO.getPw() == null || passengerDTO.getPw().trim().isEmpty()) {
            return false;
        }

        return true;
    }
    public static boolean isValidLogin(String userId, String userPw) {
        return userId != null && !userId.trim().isEmpty() && userPw != null && !userPw.trim().isEmpty();
    }
}
