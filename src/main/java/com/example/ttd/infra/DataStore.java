package com.example.ttd.infra;

import com.example.ttd.domain.dto.PassengerDTO;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static final List<PassengerDTO> passengersList = new ArrayList<>();

    static {
        initializeStaticUserList();
    }
    private static void initializeStaticUserList() {
        passengersList.add(PassengerDTO.of("seo","seo123","seodong12@12","01091880768","donghee",30000));
        passengersList.add(PassengerDTO.of("kim", "kim123", "kimdong12@12.com", "01012345678", "kimhee", 50000));
        passengersList.add(PassengerDTO.of("park", "park123", "parkdong12@12.com", "01087654321", "parkhee", 40000));
        passengersList.add(PassengerDTO.of("lee", "lee123", "leedong12@12.com", "01056789012", "leehee", 35000));
        passengersList.add(PassengerDTO.of("choi", "choi123", "choidong12@12.com", "01090817263", "choihee", 45000));
    }


}

