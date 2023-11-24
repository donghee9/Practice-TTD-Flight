package com.example.ttd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ttd.common.exception.UserNotFoundException;
import com.example.ttd.domain.dto.PassengerDTO;
import com.example.ttd.domain.service.PassengerServiceImpl;
import com.example.ttd.infra.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;
    private PassengerServiceImpl passengerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        passengerService = new PassengerServiceImpl(passengerRepository);
    }

    @Test
    public void testRegister() {
        PassengerDTO passengerDTO = PassengerDTO.of("TestName", "testUserLoginId", "test@example.com", "010-1234-5678", "password123", 100.0);
        doNothing().when(passengerRepository).save(any(PassengerDTO.class));
        passengerService.register(passengerDTO);
        verify(passengerRepository).save(passengerDTO);
    }


    @Test
    public void testLoginSuccess() {
        String userLoginId = "testUserLoginId";
        String password = "password123";

        PassengerDTO mockPassenger = PassengerDTO.of("TestName", userLoginId, "test@example.com", "010-1234-5678", password, 100.0);

        when(passengerRepository.findByUserId(userLoginId)).thenReturn(mockPassenger);


        passengerService.login(userLoginId, password);


        verify(passengerRepository).findByUserId(userLoginId);
    }

    @Test
    public void testLoginFailure() {
        String invalidUserLoginId = "invalidUserLoginId";
        String password = "password123";

        // 실패한 로그인 시나리오 설정
        when(passengerRepository.findByUserId(invalidUserLoginId)).thenThrow(new UserNotFoundException());

        // UserNotFoundException이 발생하는지 확인
        assertThrows(UserNotFoundException.class, () -> {
            passengerService.login(invalidUserLoginId, password);
        });
    }

    @Test
    public void testRechargePoint() {
        String userLoginId = "testUserLoginId";
        String password = "password123";
        double rechargeAmount = 50.0;
        double initialPoints = 100.0;

        PassengerDTO mockPassenger = PassengerDTO.of("TestName", userLoginId, "test@example.com", "010-1234-5678", password, initialPoints);

        // findByUserId 메소드에 대한 모의 행동 설정
        when(passengerRepository.findByUserId(userLoginId)).thenReturn(mockPassenger);

        // rechargePoint 메소드 호출
        double newPointBalance = passengerService.rechargePoint(userLoginId, password, rechargeAmount);

        // 포인트가 올바르게 충전되었는지 확인
        assertEquals(initialPoints + rechargeAmount, newPointBalance, 0.01);

        // updatePoints 메소드가 올바르게 호출되었는지 검증
        verify(passengerRepository).updatePoints(userLoginId, initialPoints + rechargeAmount);
    }

    @Test
    public void testUnSubscribe() {
        String userLoginId = "testUserLoginId";
        String password = "password123";

        PassengerDTO mockPassenger = PassengerDTO.of("TestName", userLoginId, "test@example.com", "010-1234-5678", password, 100.0);

        // findByUserId 메소드에 대한 모의 행동 설정
        when(passengerRepository.findByUserId(userLoginId)).thenReturn(mockPassenger);

        // unSubscribe 메소드 호출
        passengerService.unSubscribe(userLoginId, password);

        // deleteByUserId 메소드가 올바르게 호출되었는지 검증
        verify(passengerRepository).deleteByUserId(userLoginId);
    }
}

