package com.example.ttd.infra.repository;

import com.example.ttd.common.exception.UserNotFoundException;
import com.example.ttd.domain.dto.PassengerDTO;


    public interface PassengerRepository {
        void save(PassengerDTO passengerDTO) throws UserNotFoundException;
        PassengerDTO findByUserId(String userId) throws UserNotFoundException;
        void updatePoints(String userId, double newPointBalance) throws UserNotFoundException;
        void deleteByUserId(String userId) throws UserNotFoundException;
    }

