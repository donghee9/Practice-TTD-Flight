package com.example.ttd.domain.dto;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger PassengerId = new AtomicInteger(0);


    public static int getNextPassengerId() {
        return PassengerId.incrementAndGet();
    }


}
