package com.example.ttd.infra.repository.Impl;

import com.example.ttd.common.exception.UserNotFoundException;
import com.example.ttd.domain.dto.PassengerDTO;
import com.example.ttd.infra.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Iterator;

@RequiredArgsConstructor
public class PassengerRepositoryImpl implements PassengerRepository {

    private final List<PassengerDTO> passengerDTOList;

    @Override
    public void save(PassengerDTO passengerDTO) {
        for (int i = 0; i < passengerDTOList.size(); i++) {
            if (passengerDTOList.get(i).getUserLoginId().equals(passengerDTO.getUserLoginId())) {
                passengerDTOList.set(i, passengerDTO);
                return;
            }
        }
        passengerDTOList.add(passengerDTO);
    }

    @Override
    public PassengerDTO findByUserId(String userLoginId) throws UserNotFoundException {
        for (PassengerDTO dto : passengerDTOList) {
            if (dto.getUserLoginId().equals(userLoginId)) {
                return dto;
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public void updatePoints(String userLoginId, double newPointBalance) throws UserNotFoundException {
        boolean userFound = false;
        for (PassengerDTO dto : passengerDTOList) {
            if (dto.getUserLoginId().equals(userLoginId)) {
                dto.setPoint(newPointBalance);
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteByUserId(String userLoginId) throws UserNotFoundException {
        Iterator<PassengerDTO> iterator = passengerDTOList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserLoginId().equals(userLoginId)) {
                iterator.remove();
                return;
            }
        }
        throw new UserNotFoundException();
    }
}
