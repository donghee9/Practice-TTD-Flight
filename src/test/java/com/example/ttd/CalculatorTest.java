package com.example.ttd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();  // 클래스의 인스턴스 생성
        //assertEquals는 두 값이 같은지 확인하는 메서드
        assertEquals(30, calculator.add(10, 20)); // 10과 20의 결과가 30과 같은지 확인하는 메서드 3번 반복
        assertEquals(0, calculator.add(0, 0));
        assertEquals(-5, calculator.add(-10, 5));
    }
}
