package com.example.ttd.domain.service;
import com.example.ttd.common.exception.UserNotFoundException;
import com.example.ttd.domain.dto.PassengerDTO;
import com.example.ttd.infra.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Override
    public void register(PassengerDTO passengerDTO) {
        passengerRepository.save(passengerDTO);
    }

    @Override
    public void login(String userId, String userPw) throws UserNotFoundException {
        PassengerDTO passenger = passengerRepository.findByUserId(userId);

        if (!passenger.getPw().equals(userPw)) {
            throw new UserNotFoundException();
        }


    }

    @Override
    public double rechargePoint(String userId, String userPw, double point) throws UserNotFoundException {
        PassengerDTO passenger = passengerRepository.findByUserId(userId);

        if (!passenger.getPw().equals(userPw)) {
            throw new UserNotFoundException();
        }

        double newPointBalance = passenger.getPoint() + point;
        passengerRepository.updatePoints(userId, newPointBalance);
        return newPointBalance;
    }

    @Override
    public void unSubscribe(String userId, String userPw) throws UserNotFoundException {
        PassengerDTO passenger = passengerRepository.findByUserId(userId);

        if (!passenger.getPw().equals(userPw)) {
            throw new UserNotFoundException();
        }

        passengerRepository.deleteByUserId(userId);
    }
}
