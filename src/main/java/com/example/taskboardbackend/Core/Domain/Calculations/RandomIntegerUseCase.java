package com.example.taskboardbackend.Core.Domain.Calculations;

import org.springframework.stereotype.Service;

@Service
public class RandomIntegerUseCase {

    public int get(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public Integer get(Integer min, Integer max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
